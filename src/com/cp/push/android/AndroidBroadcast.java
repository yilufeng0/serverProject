package com.cp.push.android;

import com.cp.push.AndroidNotification;

public class AndroidBroadcast extends AndroidNotification {
 
	/**
	 * Android消息广播推送
	 */
	public AndroidBroadcast(){
		try {
			this.setPreKeyValue("type", "broadcast");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
