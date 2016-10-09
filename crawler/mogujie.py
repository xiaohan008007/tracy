#!/usr/bin/python
# -*- coding: utf-8 -*-
'''
Created on 2012-3-10

@author: Thuram
'''
from BeautifulSoup import BeautifulSoup
import json
import os
import re
import urllib
import urllib2
import time


class Retriever(object):    

    def __init__(self, read_page, output):
        self.url_file = 'temp/mogujie.urls' # 暂存detail页url
        self.host = 'http://www.mogujie.com'
        self.ajax_url = "http://www.mogujie.com/book/ajax"
        self.catalog_dict = {1:'clothing/衣服/', 2:'shoes/鞋子/', 3:'bags/包包/'}
        self.catalog = 1
        self.post_params = {}
        self.fail_parsed_urls = {}
        self.read_page = read_page
        self.output = output
            
    def get_params(self, content):
        if self.post_params.has_key('book'):
            json_result = json.loads(content)
            if json_result and json_result['status'] and 1001 == json_result['status']['code']:
                self.post_params['lastTweetId'] = json_result['result']['data']['lastTweetId']
                return json_result['result']['html']['book']
        else:
            book_list = re.search('book:"(.+?)"',content)
            if book_list:
                book = book_list.group(1)
            lastTweetId_list = re.search('lastTweetId:"(.+?)"', content)
            if lastTweetId_list:
                lastTweetId = lastTweetId_list.group(1)
            self.post_params['book']=book
            self.post_params['lastTweetId']=lastTweetId
            self.post_params['totalCol']=4
            
            
    def direct_detail_url(self, url):
        '''
        直接（同步）请求list页面，返回的太累页url列表
        '''
        print 'request at:', url
        urls = {}
        try:
            html_content = self.read_page(url)
            if not html_content: return
            soup = BeautifulSoup(html_content)
            # 请求参数
            mogupro = soup.find(text=re.compile("MOGUPROFILE[\s]*=[\s]*{.*}"))
            if mogupro:
                self.get_params(mogupro)
            # detail页面url
            details = soup.findAll(attrs={"type":"goods"})
            for item in details:
                detail_url = ''
                # 获取商品Detail页url
                a_list = item.findAll('a')
                for a_tag in a_list:
                    # 保护图片的a标签，认作是detail页
                    if a_tag.img:
                        detail_url = a_tag.attrMap['href']
                        break
                        
                if detail_url:
                    urls[detail_url] = a_tag.img['src']

            self.write_url_file(urls)
        except Exception, reason:
            print 'Parse page error:', url
            print reason          
 
    def ajax_detail_url(self):
        '''
        ajax请求list页，返回detail页url列表
        '''
        urls = {}
        try:
            params = urllib.urlencode(self.post_params)
            request = urllib2.Request(self.ajax_url, params)  
            print 'request at:', request
            html_content = self.read_page(request)
            if not html_content: return
            html = self.get_params(html_content)
            if html:
                for item in html:
                    soup = BeautifulSoup(item)
                    # 获取商品Detail页url
                    a_list = soup.findAll('a')
                    for a_tag in a_list:
                        # 保护图片的a标签，认作是detail页
                        if a_tag.img:
                            detail_url = a_tag['href']
                            if detail_url and detail_url.startswith('/note'):
                                break
                            
                    if detail_url:
                        urls[detail_url] = a_tag.img['src']
                        
            self.write_url_file(urls)
        except Exception, reason:
            print 'Parse page error:', self.post_params
            print reason

    def fetch_detail(self):
        # 按类目循环        
        for k,v in self.catalog_dict.items():
            self.catalog = k
            # 先最热，再最新
            for dimension in ('hot7day', 'new'):
                self.post_params.clear()
                url = 'http://www.mogujie.com/book/%s1/%s' % (v,dimension)
                self.direct_detail_url(url)
                for i in range(1, 6):
                    self.ajax_detail_url()
        
                            
    def crawl(self):
        try:
            if os.path.isfile(self.url_file):
                os.remove(self.url_file)
        except:
            pass
        
        print '[Retriever] Start to fetch mogujie detail urls.'
        self.fetch_detail()
        print '[Retriever] End fetching mogujie detail urls.'
        
        url_file = open(self.url_file, 'r')
        details = url_file.readlines()
        url_file.close()        
        if not details: return
        print '[Retriever] Start to parse mogujie detail pages.'
        # 解析detail页
        for item in details:
            args = item.split(',')
            self.parse(args[0], ''.join([self.host, args[1].rstrip()]), args[2])
            
        # 对第一次解析失败的页面，再尝试解析一次
        for url in self.fail_parsed_urls.keys():
            catalog = self.fail_parsed_urls[url]
            del self.fail_parsed_urls[url]
            self.parse(catalog, url)
        print '[Retriever] End parsing mogujie detail pages.'
        
    def parse(self, catalog, url, list_img):
        print 'parse detail:', url
        detail_content = self.read_page(url)
        if not detail_content:
            self.fail_parsed_urls[url] = catalog
            return

        soup = BeautifulSoup(detail_content)
        detail_img = soup.find(attrs={'class':'show_big qplus_link'}).find('img')['src']
        shop_link = soup.find('a', attrs={'class':'shop_link'})
        item_url = ''
        if shop_link:
            item_url = shop_link.attrMap['href']
            
        item_id = self.parse_taobao_id(item_url)
                    
        if item_id:
            red_nums = soup.find(attrs={'class':'favCount'})
            fav_count = red_nums.string if red_nums and red_nums.string else '0'
            self.output(catalog, item_id, fav_count, list_img, detail_img)
            
    def parse_taobao_id(self, url):
        '''
        从url中解析淘宝商品id
        '''
        id_groups = re.search('http%3A%2F%2Fitem.taobao.com%2Fitem.htm%3Fid%3D(\d*)', url)
        if id_groups:
            return id_groups.group(1)
            
    def write_url_file(self, urls):
        if not urls: return
        detail_file = open(self.url_file, 'a')
        try:
            for key in urls:
                url_re = re.search('(/note/[^\?]+)', key)
                detail_url = url_re.group(1) if url_re else key
                detail_file.write('%d,%s,%s\n' % (self.catalog, detail_url, urls[key]))
        finally:
            detail_file.close()
        