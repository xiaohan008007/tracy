/**
 * 
 */
package com.tracy.net.TCP.httpServer;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * @author tracy.lu
 * @date:2016年4月21日 下午6:24:20
 * @version :
 */
public class Request {

    private static final String       BLANK        = " ";
    private static final String       CRLF         = "\r\n";
    private String                    requestInfo;
    private String                    paramString;
    private String                    url;
    private Map<String, List<String>> parameterMap = new HashMap<String, List<String>>();

    public Request(Socket socket) throws IOException {
        InputStream is;
        is = new BufferedInputStream(socket.getInputStream());
        byte[] flush = new byte[2048];
        int len = is.read(flush);
        requestInfo = new String(flush, 0, len);

        String method = requestInfo.substring(0, requestInfo.indexOf(BLANK));
        url = requestInfo.substring(requestInfo.indexOf("/"), requestInfo.indexOf("HTTP") - 1);
        if ("GET".equals(method)) {
            if (url.contains("?")) {
                paramString = url.substring(url.indexOf("\\?"));
                url = url.substring(0, url.indexOf("\\?"));
            }
        } else if ("POST".equals(method)) {
            paramString = requestInfo.substring(requestInfo.lastIndexOf(CRLF)).trim();
        }
        parseParam();
    }

    /**
     * 初始化参数map
     */
    public void parseParam() {
        if (StringUtils.isBlank(paramString)) return;
        String[] paramGroup = paramString.split("&");
        for (String param : paramGroup) {
            String key = param.split("=")[0];
            String value = param.split("=")[1];
            List<String> paramValueList = new ArrayList<String>();
            if (parameterMap.containsKey(key)) {
                paramValueList = parameterMap.get(key);
            }
            paramValueList.add(value);
            parameterMap.put(key, paramValueList);

        }
    }

    public String getParameter(String key) {
        String[] params = getParameters(key);
        if (params == null) return null;
        return params[0];
    }

    public String[] getParameters(String key) {
        List<String> values = null;
        if ((values = parameterMap.get(key)) == null) {
            return null;
        } else {
            return values.toArray(new String[] {});
        }

    }
}
