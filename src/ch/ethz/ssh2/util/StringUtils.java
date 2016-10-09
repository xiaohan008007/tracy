/**
 * 
 */
package ch.ethz.ssh2.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tracy.lu
 * @date:2012-8-16 下午8:04:21
 * @version :
 */
public class StringUtils extends org.apache.commons.lang.StringUtils{
    
   // 1、空字符判断

    public static boolean isEmpty(String str){
        return (str == null || str.length() < 1);
    }
    

    public static boolean isNotEmpty(String str){
        return !StringUtils.isEmpty(str);
    }
    
    public static boolean isBlank(String str){
        if(str == null || str.length() < 1){
            return true;
        }
        int strLen = str.length();
        for(int i = 0; i < strLen; i++){
            if(Character.isWhitespace(str.charAt(i)) == false){
                return false;
            }
        }
        return true;
    }
    
    public static boolean isNotBlank(String str){
        return !StringUtils.isBlank(str);
    }

//isEmpty是判断一个String是否为null或者为""
//isBlank是判断一个String是否为null或者为""或者为"   "
//
//有时候，我们需要判断一个字符串是否是int型数字，是否为double数字等等

    
    //2、数字判断

public static boolean isIntNumString(String str){
        if(str == null){
            return false;
        }
        try{
            Integer.parseInt(str);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public static boolean isNumString(String str){
        if(str == null){
            return false;
        }
        try{
            Double.parseDouble(str);
            return true;
        }catch(Exception e){
            return false;
        }
    }
//这里，我们利用Java的异常机制，当转换成数字的过程中出异常了，说明该字符串不是一个规则的“数字型字符串”
//
//在String的使用过程中经常需要加入if(str==null)这种判断，能否提供null ignore的方法，从而省略这种判断呢？

    
    //3、对String的扩展

    public static String toUppderCase(String str){
        if(str == null || str.length() < 1){
            return str;
        }else{
            return str.toUpperCase();
        }
    }
    
    public static String toLowerCase(String str){
        if(str == null || str.length() < 1){
            return str;
        }else{
            return str.toLowerCase();
        }
    }
    
    public static boolean startsWithIgnoreCase(String source, String prefix){
        if(source != null && prefix != null){
            if(source.startsWith(prefix)){
                return true;
            }else{
                return (StringUtils.toLowerCase(source)).startsWith(StringUtils.toLowerCase(prefix));
            }
        }
        return false;
    }
    
    public static boolean startsWithIgnoreCase(String source, String prefix , int toOffset){
        if(source != null && prefix != null){
            if(source.startsWith(prefix , toOffset)){
                return true;
            }else{
                return (StringUtils.toLowerCase(source)).startsWith(StringUtils.toLowerCase(prefix), toOffset);
            }
        }
        return false;
    
    }
    
    public static boolean startsWith(String source, String prefix){
        if(source != null && prefix != null){
            if(source.startsWith(prefix)){
                return true;
            }
        }
        return false;
    }
    

    public static boolean startsWith(String source, String prefix , int toOffset){
        if(source != null && prefix != null){
            if(source.startsWith(prefix , toOffset)){
                return true;
            }
        }
        return false;
    
    }

    public static boolean contains(String source, String strToCheck){
        if(source != null){
            return source.contains(strToCheck);
        }
        return false;
    }

    public static int length(String str){
        if(StringUtils.isEmpty(str)){
             return 0;
        }else{
             return str.length();
        }
    }

    public static byte[] getBytes(String str){
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        
    }

    public static String subString(String sourceStr, int fromIndex, int toIndex){
           int len = sourceStr.length();
           if(toIndex > len){
               return sourceStr.substring(fromIndex, len);
           }else{
               return sourceStr.substring(fromIndex, toIndex);
           }
      }
       
//其中startsWithIgnoreCase方法不仅扩展了String类的startsWidth方法的null ignore还扩展了case insensitive
//getBytes方法相对于String类的对应方法则提供了Exception ignore便利，毕竟不需要每次都需要写上try...catch对于指定UTF-8 的Encoding转码，其他格式如GB2312编码的会在ByteUtils类提供，后
//
//面章节会涉及
//
//判断一个字符串是否在指定的字符串列表里面，也是一个很常见的需求，比如从一个Name List里面找到指定的Name

    
    
    //4.常见的String List查找
    
    public static boolean isInList(String strToCheck, String... strList){
        return isInList(strToCheck, false, strList);
    }
    
    public static boolean isInList(String strToCheck, boolean ignoreCase, String ... strList){
        for(String str : strList){
            if(ignoreCase && str.equalsIgnoreCase(strToCheck)){
                return true;
            }else if(!ignoreCase && str.equals(strToCheck)){
                return true;
            }
        }
        return false;
    }

//5. Number To String
    
    public static String toString(int i){
        return i + EMPTY;
    }

    public static String toString(double d){
        return d + EMPTY;
    }
    
    public static String toString(float f){
        return f + EMPTY;
    }
    
    public static String toString(long l){
        return l + EMPTY;
    }
    
    public static String toString(boolean b){
        return b + EMPTY;
    }
    
    public static String toString(char c){
        return c + EMPTY;
    }

    public static String[] toStringArray(int[] intArray){
        int length = intArray.length;
        String[] strArray = new String[length];
        for(int i = 0; i < length; i++){
            strArray[i] = StringUtils.toString(intArray[i]);
        }
        return strArray;
    }
    
//6、toHexString以及null ignore的toString方法

    public static String toHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
    
    public static String toString(String str, String defaultValue){
        if(str == null){
            return defaultValue;
        }
        return str;
    }

//7、特殊格式的String判断和转换
    
    public static boolean isUpperCase(String str){
        if(StringUtils.isNotBlank(str)){
            char[] cs = str.toCharArray();
            for(char c : cs){
                if(Character.isLowerCase(c)){
                    return false;
                }
            }
            return true;
        }else{
            return true;
        }
    }
    

    public static boolean isLowerCase(String str){
        if(StringUtils.isNotBlank(str)){
            char[] cs = str.toCharArray();
            for(char c : cs){
                if(Character.isUpperCase(c)){
                    return false;
                }
            }
            return true;
        }else{
            return true;
        }
    }
    
    public static String firstLetterUpper(String str){
        if(StringUtils.isBlank(str)){
            return str;
        }else if(str.length() == 1){
            return StringUtils.EMPTY + Character.toUpperCase(str.charAt(0));
        }else{
            char headerChar = str.charAt(0);
            return Character.toUpperCase(headerChar) + str.substring(1);
        }
    
    }
    
    public static String firstLetterLower(String str){
        if(StringUtils.isBlank(str)){
            return str;
        }else if(str.length() == 1){
            return StringUtils.EMPTY + Character.toLowerCase((str.charAt(0)));
        }else{
            char headerChar = str.charAt(0);
            return Character.toLowerCase(headerChar) + str.substring(1);
        }
    
    }
    
      public static String[] getSegments(String sourceStr, int segLen){
           int len = sourceStr.length();
           if(len < segLen){
               return new String[]{sourceStr};
           }else{
               int segNum = len / segLen + 1;
               if(len % segLen ==0){
                   segNum = len / segLen;
               }
               String[] result = new String[segNum];
               for(int i=0; i<segNum; i++){
                  
                   result[i] = subString(sourceStr, i * segLen, (i+1) * segLen);
               }
               return result;
           }
       }

       public static String omitString(String source, int maxLength, String omitStr){
           if(StringUtils.length(source) < maxLength){
               return source;
           }else{
               return StringUtils.subString(source, 0, maxLength) + omitStr;
           }
       }
       
       public static String omitString(String source, int maxLength){
           return StringUtils.omitString(source, maxLength, "...");
       }    

//isUpperCase和isLowerCase是断定是否整个字符串中每个字符都是大写或者小写格式
//firstLetterUpper将一个字符串中第一个字符大写，这在取javaBean中每个域的的set和get方法时有用，比如age的get方法是getAge，只需要将age的每一个字符转成大写格式。
//getSegments，分页相信大家都熟悉，这个方法其实类似，但不是分页，是分段，一个长的String可以转换成指定长度的段比如abcdef转换成长度为3的段结果是["abc","def"]。
//omitString，其实是用来省略字符串的，比如常见的一个页面显示不了那么多内容，以...代替，当点击了该页后再显示详细内容。《Apple human guide line》指出不该使用这种方式，这种方式出现的
//
//唯一原因是你该整理你的语句了。anyway，这里编程上还是提供了这个方法供选择。
//
//在Java中String类的split(String regex)方法其实是调用Pattern类的split方法完成的，正则表达式的方法在Java中效率并不高，这里提供一个最常见的场景下使用的split方法，通过遍历字符串的方
//
//式来split，从而将性能提高30%。

       
       //8、提高效率的split方法

//测试先行，测试用例
//    public static void main(String args[]){
//        String str = "abcdef#gh#ijkll";
//        StopWatch watch = new StopWatch();
//        for(int i=0; i<1000000; i++){
//              //StringUtils.split(str, '#',true);
//              str.split("#");
//        }
//        System.out.println(watch.getInterval());
//    }

//在笔者开发机器上执行100万次的时间比分别是
//String类: 1609ms
//StringUtils类: 1042ms
//
//split方法源码
    
    public static String[] split(String source){
        return split(source, '#', true);
    }
    
    public static String[] split(String source, char splitChar, boolean ignoreBlank){
        char[] chars = source.toCharArray();
        char escapeChar = '\\';
        StringBuilder sb = new StringBuilder();
        boolean ifRecSplitChar = false;
        List<String> strList = new ArrayList<String>();
        for(char c : chars){
            if(!ifRecSplitChar && c == splitChar){
                ifRecSplitChar = false;
                if(ignoreBlank){
                    strList.add(sb.toString().trim());
                }else{
                    strList.add(sb.toString());
                }
                sb = new StringBuilder();
            }else{
                if(c == escapeChar){
                    ifRecSplitChar = true;
                }else{
                    sb.append(c);
                    ifRecSplitChar = false;
                }
            }
        }
        if(ignoreBlank){
            strList.add(sb.toString().trim());
        }else{
            strList.add(sb.toString());
        }
        return strList.toArray(new String[]{});
    }

//第一个方法以#为默认的splitChar，以后在读取properties配置文件时也以它为默认的分隔符。
}
