/**
 * 
 */
package com.tracy.net.TCP.httpServer;

/**
 * @author tracy.lu
 * @date:2016年4月21日 下午7:19:32
 * @version :
 */
public class Servlet {

    // StringBuilder content = new StringBuilder();
    // content.append("<html><head><title>测试response</title></head>");
    // content.append("<body>" + name + "</body></html>");
    // return content;
    public void service(Request request, Response response) {
        response.print("<html><head><title>测试response</title></head>").print("<body>").print(request.getParameter("name")).print("</body></html>");
    }
}
