/**
 * 
 */
package com.tracy.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;

import com.taotaosou.foundation.base.util.common.http.HttpClientUtil;

/**
 * @author tracy.lu
 * @date:2016年1月11日 下午5:40:27
 * @version :
 */
public class PostMethodTest {

    public static String input_charset = "UTF-8";
    public static String gateway       = "http://api.wax.weibo.com/account/config";

    public static String token         = "";
    public static String dspid         = "";

    /**
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException { // out对象
        // PrintWriter out = _response.getWriter();
        Map<String, String> sParaTemp = new HashMap<String, String>();
        sParaTemp.put("dspid", dspid);
        sParaTemp.put("token", token);
        sParaTemp.put("bid_url", "");
        sParaTemp.put("win_notice_url", "");
        sParaTemp.put("qps", "100");
        String result = HttpClientUtil.getInstance().post(gateway, sParaTemp);
        result = StringEscapeUtils.unescapeJava(result);
        // result = URLDecoder.decode(result, "UTF-8");
        System.out.println(result);
        // String sHtmlText = buildForm(sParaTemp, gateway, "post", "确认");
        // System.out.println(sHtmlText);
        // out.println(sHtmlText);

    }

    /**
     * 构造提交表单HTML数据
     * 
     * @param sParaTemp 请求参数数组
     * @param gateway 网关地址
     * @param strMethod 提交方式。两个值可选：post、get
     * @param strButtonName 确认按钮显示文字
     * @return 提交表单HTML文本
     */
    public static String buildForm(Map<String, String> sParaTemp, String gateway, String strMethod, String strButtonName) {
        // 待请求参数数组
        // Map<String, String> sPara = buildRequestPara(sParaTemp);
        List<String> keys = new ArrayList<String>(sParaTemp.keySet());

        StringBuffer sbHtml = new StringBuffer();

        sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + gateway + "_input_charset="
                      + input_charset + "\" method=\"" + strMethod + "\">");

        for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            String value = (String) sParaTemp.get(name);

            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }

        // submit按钮控件请不要含有name属性
        sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");
        sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");

        return sbHtml.toString();
    }
}
