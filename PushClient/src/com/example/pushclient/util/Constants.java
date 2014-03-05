package com.example.pushclient.util;

public class Constants {
	public final static int PUSH_MESSAGE_INSIGNIFICANT=0;//不重要消息
	public final static int PUSH_MESSAGE_NORMAL=1;//普通消息
	public final static int PUSH_MESSAGE_NORMAL_MAIL=2;//普通消息-消息+网络方式
	public final static int PUSH_MESSAGE_IMPORTANT=3;//重要消息-网络方式
	public final static int PUSH_MESSAGE_IMPORTANT_SMS=4;//重要消息-网络+短信方式
	public final static int PUSH_MESSAGE_IMPORTANT_MAIL=5;//重要消息-网络+邮件方式
	public final static int PUSH_MESSAGE_IMPORTANT_MAIL_SMS=6;//重要消息-邮件+短信方式
	public final static int PUSH_MESSAGE_IMPORTANT_ALL=7;//重要消息-网络+邮件+短信方式
}
