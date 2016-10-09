# This Python file uses the following encoding: utf-8
from twisted.web.client import getPage
from twisted.internet import reactor
 
links = [ 'http://www.verycd.com/topics/%d/'%i for i in range(5420,5423) ]
 
def parse_page(data,url):
    print data,url
 
def fetch_error(error,url):
    print error.getErrorMessage(),url
    
def main():
# 批量抓取链接
    for url in links:
        getPage(url,timeout=5).addCallback(parse_page,url).addErrback(fetch_error,url)     #失败则调用fetch_error方法
     
    reactor.callLater(5, reactor.stop) #5秒钟后通知reactor结束程序
    reactor.run()



if __name__ == '__main__':
    main()