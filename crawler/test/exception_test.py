# This Python file uses the following encoding: utf-8
try:
    x=int(raw_input("请输入数字:"))
except ValueError: #可以同时捕获多个异常,写法如except(RuntimeError,ValueError):
    #当输入非数字时
    print"您输入不是数字"
except: #省略异常名,可以匹配所有异常,慎用
    pass
else:#当没有异常时
    print 'result=',x
finally:#和Java中类似。一般用于释放资源，如文件，网络连接。
   print 'finish'