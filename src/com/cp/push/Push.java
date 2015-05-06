package com.cp.push;

import com.cp.push.android.AndroidBroadcast;
import com.cp.push.ios.IOSBroadCast;

/**
 * 实现对IOS和Android客户端的消息推送
 *
 */
public class Push {
	private String appkey = null;
	private String appMasterSecret = null;
	private String timestamp = null;
	
	public Push(String appKey, String appMasterSecret){
		this.appkey = appKey;
		this.appMasterSecret = appMasterSecret;
		this.timestamp = Integer.toString((int)(System.currentTimeMillis()/1000));
	}
	
	/**
	 * Android广播的键值设置以及消息POST
	 * @throws Exception
	 */
	public void sendAndroidBroadcast(String ticker,String title,String text,String targetUrl) throws Exception{
		AndroidBroadcast broadcast = new AndroidBroadcast();
		broadcast.setPreKeyValue("appkey", this.appkey);                    //root level
		broadcast.setAppMasterSecret(this.appMasterSecret);
		broadcast.setPreKeyValue("timestamp", this.timestamp);
		//broadcast.setPreKeyValue("device_tokens", new GetPushParameter().getDevice_Token("android"));   //测试单播时需要添加device_token
		broadcast.setPreKeyValue("display_type", "notification");           //payload level
		
		broadcast.setPreKeyValue("ticker", ticker);     //body level
		broadcast.setPreKeyValue("title", title);
		broadcast.setPreKeyValue("text", text);
		broadcast.setPreKeyValue("after_open", "go_custom");
		broadcast.setPreKeyValue("production_mode", "false");               //true为正式模式，false为测试模式
		broadcast.setPreKeyValue("targetUrl", targetUrl);
		
		broadcast.sendPush();                                               //将消息POST出去
		System.out.println("pushing...");
	}
	
	/**
	 * IOS广播的键值设置以及消息POST
	 * @throws Exception
	 */
	public void sendIOSBroadcast(String title,String targetUrl) throws Exception{
		IOSBroadCast broadcast = new IOSBroadCast();
		broadcast.setPreKeyValue("appkey", this.appkey);              //root level
		broadcast.setAppMasterSecret(this.appMasterSecret);
		broadcast.setPreKeyValue("timestamp", this.timestamp);
		//broadcast.setPreKeyValue("device_tokens", new GetPushParameter().getDevice_Token("ios"));
		
		//broadcast.setPreKeyValue("display_type", "notification");     //payload level
		
		broadcast.setPreKeyValue("alert", title);                      //aps level 
		broadcast.setPreKeyValue("badge", 0);
		broadcast.setPreKeyValue("sound", "chime");
		broadcast.setPreKeyValue("production_mode", "false");         //true为正式模式，false为测试模式
		
		broadcast.setPreKeyValue("targetUrl", targetUrl);             //推送跳转页面url

		broadcast.sendPush();                                         //将消息POST出去
		System.out.println("pushing...");
	}
	
	public static void main(String[] args) throws Exception {
		//Push push = new Push("your appkey", "the app master secret");
		//push.sendAndroidBroadcast();
		//push.sendIOSBroadcast();
	}

}
