#!/usr/bin/python
# -*- coding: utf-8 -*-
'''
Created on 2012-3-10

@author: Eason
'''
from BeautifulSoup import BeautifulSoup
import json
import os
import re

class Retriever(object):
    '''抓取页面 '''

    def __init__(self, read_page, output):
        self.url_file = 'temp/meilishuo.urls' # 暂存detail页url        
        self.host = 'http://www.meilishuo.com'
        self.catalog_dict = {1:'dress/2000000000000/', 2:'shoes/6000000000000/', 3:'bag/5000000000000/'}
        self.catalog = 1
        self.ajax_request_finished = False
        self.fail_parsed_urls = {}
        self.read_page = read_page
        self.output = output
            
    
    def direct_detail_url(self, url):
        '''
        直接（同步）请求list页面，返回以detail页url为key，list页图片url为value的字典对象
        '''
        print 'request at:', url
        urls = {}
        try:
            html_content = self.read_page(url)
            if not html_content: return
            soup = BeautifulSoup(html_content)
            details = soup.findAll(attrs={"class":"hp_top"})
            for item in details:
                self.parse_detail_url(item, urls)
                    
            if urls:
                self.write_url_file(urls)
        except Exception, reason:
            print 'Parse page error:', url
            print reason
 
    def ajax_detail_url(self, url):
        '''
        ajax请求list页，返回detail页url列表
        '''
        print 'request at:', url
        urls = {}
        try:
            html_content = self.read_page(url)
            print html_content
            if not html_content: return            
            json_result = json.loads(html_content)
            print json_result
            if json_result['status']:
                htmls = json_result['html']
                for html in htmls:
                	print html
                for html in htmls:
                    item = BeautifulSoup(html)
                    self.parse_detail_url(item, urls)
               
                self.ajax_request_finished = json_result['finish']
                
            if urls:
                self.write_url_file(urls)
        except Exception, reason:
            print 'Parse page error:', url
            print reason

    def parse_detail_url(self, item_soup, dict):
        '''解析url信息'''
        detail_url = ''
        img_url = ''
        # 获取商品Detail页url
        a_list = item_soup.findAll('a')
        for a_tag in a_list:
            # 保护图片的a标签，认作是detail页
            if a_tag.img:
                detail_url = a_tag['href']
                break
                
        if detail_url:
            dict[detail_url] = a_tag.img['src']
            
    def parse(self, catalog, url, list_img):
        '''
            解析detail页面
        '''
        print 'parse detail:', url
        detail_content = self.read_page(url)
        if not detail_content:
            self.fail_parsed_urls[url] = catalog
            return
        soup = BeautifulSoup(detail_content)
        detail = soup.find(attrs={'class':'goodsdetail'})
        if not detail: return
        detail_img = soup.find(attrs={'class':'code_pic'}).find('img')['src']
        goods_title = detail.find(attrs={'class':'goods_title'})
        item_url = ''
        if goods_title:
            item_url = goods_title.attrMap['href']
        else:
            go_buy = detail.find(text=re.compile(u'去购买'))
            if go_buy:
                item_url = go_buy.parent.attrMap['href']
            
        item_id = self.parse_taobao_id(item_url)
    
        if item_id:
            red_nums = detail.find('span', attrs={'class':'likeNum'})
            fav_count = red_nums.string if red_nums and red_nums.string else '0'
            self.output(catalog, item_id, fav_count, list_img, detail_img)

    def parse_taobao_id(self, url):
        '''
        从url中解析淘宝商品id,美丽说专用
        '''
        if 'javascript:void(0)' == url:
            return 
        redirect_page = self.read_page(url)
        if not redirect_page:
            return 
        soup = BeautifulSoup(redirect_page)
        if not soup.body or not soup.body.script:
            return
        js = soup.body.script.contents[0]
        item_id = re.search("[\?|&]id=(\d{10,12})",js)
        if item_id:
            item_id = item_id.group(1)
            return item_id
        
    def fetch_detail_urls(self):
        # 按类目循环        
        for k,v in self.catalog_dict.items():
            self.catalog = k
            # 先最热，再最新
            for dimension in ('7d', 'new'):
                self.ajax_request_finished = False
                url = self.entry_point(v, dimension)
                if not url: continue
                self.direct_detail_url(url)
                for frame in range(1, 5):
                    if self.ajax_request_finished:
                        break
                    url = self.entry_point(v, dimension, True, frame)
                    self.ajax_detail_url(url)
                
    def entry_point(self, keyword, dimension, asyn=False, frame=1):
        '''
        list页入口
        '''
        if not keyword: return
        if asyn:
            return 'http://www.meilishuo.com/goods/ajax_catalog/%s%s?view=1&word=0&global=0&page=0&frame=%d' % (keyword,dimension,frame)
        else:
            return 'http://www.meilishuo.com/goods/catalog/%s%s' % (keyword,dimension)
            
    def write_url_file(self, urls):
        if not urls: return
        detail_file = open(self.url_file, 'a')#读写模式:r只读,r+读写,w新建(会覆盖原有文件),a追加,b二进制文件.常用模式如:'rb','wb','r+b'等等
        try:
            for key in urls:
                detail_file.write('%d,%s,%s\n' % (self.catalog, key, urls[key]))
        finally:
            detail_file.close()
            
    # 爬取数据写入文件   
    def crawl(self):
        try:
            if os.path.isfile(self.url_file):
                os.remove(self.url_file)
        except:
            pass
        
        print '[Retriever] Start to fetch meilishuo detail urls.'
        self.fetch_detail_urls()
        print '[Retriever] End fetching meilishuo detail urls.'
        
        url_file = open(self.url_file, 'r')
        details = url_file.readlines()
        url_file.close()
        
        if not details: return
        print '[Retriever] Start to parse meilishuo detail pages.'
        # 解析detail页
        for item in details:
            args = item.split(',')
            self.parse(args[0], ''.join([self.host, args[1].rstrip()]), args[2])
            
        # 对第一次解析失败的页面，再尝试解析一次
        for url in self.fail_parsed_urls.keys():
            catalog = self.fail_parsed_urls[url]
            del self.fail_parsed_urls[url]
            self.parse(catalog, url)
        print '[Retriever] End parsing meilishuo detail pages.'