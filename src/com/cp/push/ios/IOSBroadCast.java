package com.cp.push.ios;

import com.cp.push.IOSNotification;

public class IOSBroadCast extends IOSNotification {
     /**
     * IOS消息广播推送
     */
    public IOSBroadCast() {
		try {
			//this.setPreKeyValue("type", "broadcast");
			this.setPreKeyValue("type", "unicast");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
