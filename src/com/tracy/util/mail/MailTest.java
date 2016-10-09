package com.tracy.util.mail;
public class MailTest {
public static void main(String[] args){   
        //这个类主要是设置邮件   
     MailSenderInfo mailInfo = new MailSenderInfo();    
     mailInfo.setMailServerHost("mail.taotaosou.com");    
     //mailInfo.setMailServerPort("25");    
     mailInfo.setValidate(true);    
     mailInfo.setUserName("danqing");    
     mailInfo.setPassword("138165");//您的邮箱密码    
     mailInfo.setFromAddress("danqing@taotaosou.com"); 
     mailInfo.setToAddress(new String[]{"xiaohan008007@163.com"}); 
    // mailInfo.setAttachFileNames(new String[]{"c:\\email.txt","c:\\emai.txt"});
     mailInfo.setSubject("主题12");    
     mailInfo.setContent("<font style='BACKGROUND-COLOR: #666699' color='#ff0000' size='5'>测试格式化内容测试<a href='http://www.baidu.com'>格式化内容</a>测试格<em>式化</em>内容</font><img src='http://www.google.cn/intl/zh-CN/images/logo_cn.gif'></img>");    
        //这个类主要来发送邮件   
     SimpleMailSender sms = new SimpleMailSender();   
         //sms.sendTextMail(mailInfo);//发送文体格式    
         sms.sendHtmlMail(mailInfo);//发送html格式   
   }
}