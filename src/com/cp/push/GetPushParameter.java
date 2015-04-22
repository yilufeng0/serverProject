package com.cp.push;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class GetPushParameter {
	private Context initCtx = null;
	private Context envCtx = null;
	
	public GetPushParameter(){
		try {
			initCtx = new InitialContext();
			envCtx = (Context)initCtx.lookup("java:comp/env");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
		/**
		 * 获取推送设备device_token(通过web.xml配置文件获取)
		 * @param type   android or ios 设备
		 * @return   返回设备device_token
		 */
		public String getDevice_Token(String type){
			String device_token = null;
			if(type.equals("android")){
				try {
					 device_token = (String)envCtx.lookup("DEVICE_TOKEN_ANDROID");
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			if(type.equals("ios")){
				try {
					 device_token = (String)envCtx.lookup("DEVICE_TOKEN_IOS");
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			
			return device_token;
		}
		
		
		/**
		 * 获取推送设备app_key(通过web.xml配置文件获取)
		 * @param type  android or ios 设备
		 * @return   返回设备app_key
		 */
		public String getAPP_KEY(String type){
			String app_key = null;
			if(type.equals("android")){
				try {
					app_key = (String)envCtx.lookup("APP_KEY_ANDROID");
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 	
			}
			if(type.equals("ios")){
				try {
					app_key = (String)envCtx.lookup("APP_KEY_IOS");
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}

			return app_key;
		}
		
		/**
		 * 获取推送设备app_master_secret(通过web.xml配置文件获取)
		 * @param type  android or ios 设备
		 * @return   返回设备app_master_secret
		 */
		public String getAPP_MASTER_SECRET(String type){
			String app_master_secret = null;
			if(type.equals("android")){
				try {
					app_master_secret = (String)envCtx.lookup("APP_MASTER_SECRET_ANDROID");
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 			
			}
			if(type.equals("ios")){
				try {
					app_master_secret = (String)envCtx.lookup("APP_MASTER_SECRET_IOS");
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			
			return app_master_secret;
		}
  
		
}
