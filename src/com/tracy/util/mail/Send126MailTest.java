package com.tracy.util.mail;
public class Send126MailTest {

	public static void main(String[] args) {

		//SMTP设置，包括登录用户名、密码、SMTP主机地址和端口等信息
		SMTPSetting setting = new SMTPSetting();
		setting.setSmtpHost("mail.taotaosou.com");
		//setting.setSmtpHost("192.168.1.181");
		setting.setUserName("danqing");
		setting.setPwd("138165");//换成你的密码
		
		//邮件内容
		MailMessage message = new MailMessage();
		message.setForm("tracy:danqing@taotaosou.com");//发件人
		message.getTo().add("xiaohan008007@163.com");//收件人
		message.setSubject("1");//主题
		message.setBody("<font style='BACKGROUND-COLOR: #666699' color='#ff0000' size='5'>测试格式化内容测试<a href='http://www.baidu.com'>格式化内容</a>测试格<em>式化</em>内容</font><img src='http://www.google.cn/intl/zh-CN/images/logo_cn.gif'></img>");//正文
		message.setPriority(1);//邮件优先级1为高,3为中,5为低
		message.getReplyList().add("xiaohan008007@163.com");
		//附件
		//Attachment att = new Attachment();
		//att.setFileName("xxx.java");//附件名
		//att.setFilePath("C:\\TestCase.java");//设置附件的路径
		
		//message.addAttachment(att);
		
		//发送邮件
		try {
			MailSender.sendMail(setting, message);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}