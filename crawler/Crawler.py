#!/usr/bin/python
# -*- coding: utf-8 -*-
'''
Created on 2012-3-10

@author: Thuram
'''
from sys import argv
import mogujie
import meilishuo
import os
import time
import urllib2
import threading

class Crawler(object):
    
    def __init__(self, site):
        self.site = site
        self.output = 'output/%s.data.%s' % (self.site,time.strftime('%Y%m%d', time.localtime()))
        if os.path.isfile(self.output):
            print '%s has exist, please delete it first!' % self.output
            exit(1)  
    
    def go(self):
        if 'meilishuo' == self.site:
            r = meilishuo.Retriever(self.read_page, self.output_result)
            r.crawl()
        elif 'mogujie' == self.site:
            r = mogujie.Retriever(self.read_page, self.output_result)
            r.crawl()

    def read_page(self,request,retries=3):
        try:
            res = urllib2.urlopen(request, timeout=15)
            if res.getcode() == 200:
                content = res.read()
                return content
        except Exception, reson:
            print reson
            if retries>0:
                return self.read_page(request,retries-1)
            else:
                print 'http request error:', request
                return

    def output_result(self, catalog, item_id, fav_count, s_img, b_img):
        result_file = open(self.output, 'a')
        try:
            result_file.write('%s,%s,%s,%s,%s\n' % (catalog, item_id, fav_count, s_img.rstrip(), b_img))
        finally:
            result_file.close() 

def main():
    start = time.time()
    print '[Crawler] Start to crawl at ', time.strftime('%Y-%m-%d %X', time.localtime())

    sites = []
    if len(argv) > 1:
        sites = list(argv)
    else:
        sites = ['meilishuo']
    for t in sites:
        print t    
    threads = []
    # 创建线程对象
    for site in sites:
        robot = Crawler(site)
        threads.append(threading.Thread(target=robot.go))
        
    # 启动所有线程
    for t in threads:
        t.start()
    # 等待线程结束  子线程结束后主线程才会往后运行
    for t in threads:
        t.join()
        
    end = time.time()
    print '[Crawler] End crawling at %s. cost time: %.2f s' % (time.strftime('%Y-%m-%d %X', time.localtime()), end - start)
    
if __name__ == '__main__':
    main()