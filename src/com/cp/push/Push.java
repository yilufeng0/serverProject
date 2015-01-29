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
	public void sendAndroidBroadcast() throws Exception{
		AndroidBroadcast broadcast = new AndroidBroadcast();
		broadcast.setPreKeyValue("appkey", this.appkey);                    //root level
		broadcast.setAppMasterSecret(this.appMasterSecret);
		broadcast.setPreKeyValue("timestamp", this.timestamp);
		broadcast.setPreKeyValue("type", "broadcast");                      //消息发送类型为广播
		
		broadcast.setPreKeyValue("display_type", "notification");           //payload level
		
		broadcast.setPreKeyValue("ticker", "Android broadcast ticker");     //body level
		broadcast.setPreKeyValue("title", "中文的title");
		broadcast.setPreKeyValue("text", "Android broadcast text");
		broadcast.setPreKeyValue("after_open", "go_app");
		broadcast.setPreKeyValue("production_mode", "false");               //true为正式模式，false为测试模式
		
		broadcast.sendPush();                                               //将消息POST出去
	}
	
	/**
	 * IOS广播的键值设置以及消息POST
	 * @throws Exception
	 */
	public void sendIOSBroadcast() throws Exception{
		IOSBroadCast broadcast = new IOSBroadCast();
		broadcast.setPreKeyValue("appkey", this.appkey);              //root level
		broadcast.setAppMasterSecret(this.appMasterSecret);
		broadcast.setPreKeyValue("timestamp", this.timestamp);
		broadcast.setPreKeyValue("type", "broadcast");                //消息发送类型为广播
		
		broadcast.setPreKeyValue("display_type", "notification");     //payload level
		
		broadcast.setPreKeyValue("alert", "IOS 广播测试");             //aps level
		broadcast.setPreKeyValue("badge", 0);
		broadcast.setPreKeyValue("sound", "chime");
		broadcast.setPreKeyValue("production_mode", "false");         //true为正式模式，false为测试模式
		
		broadcast.sendPush();                                         //将消息POST出去
		
	}
	
	public static void main(String[] args) throws Exception {
		Push push = new Push("your appkey", "the app master secret");
		//push.sendAndroidBroadcast();
		push.sendIOSBroadcast();
	}

}
