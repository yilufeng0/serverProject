package com.cp.push;

import java.util.Arrays;
import java.util.HashSet;

import org.json.JSONObject;

public class AndroidNotification extends BaseNotification{
	protected static final HashSet<String> PAYLOAD_KEYS = new HashSet<String>(Arrays.asList(new String[]{"display_type"}));
	protected static final HashSet<String> BODY_KEYS = new HashSet<String>(Arrays.asList(new String[]{"ticker","title","text","after_open"}));

	/**
	 * Android端的键值设置
	 * @param key    JSON串中的键
	 * @param value  JSON串中的值
	 * @return       设置成功，返回真
	 * @throws Exception
	 */
	public boolean setPreKeyValue(String key, Object value) throws Exception {
		if (BASE_KEYS.contains(key)) {   
	   // This key should be in the root level
			baseJson.put(key, value);
		} else if (PAYLOAD_KEYS.contains(key)) {
			// This key should be in the payload level
			JSONObject payloadJson = null;
			if (baseJson.has("payload")) {
				payloadJson = baseJson.getJSONObject("payload");
			} else {
				payloadJson = new JSONObject();
				baseJson.put("payload", payloadJson);
			}
			payloadJson.put(key, value);
		} else if (BODY_KEYS.contains(key)) {
			// This key should be in the body level
			JSONObject bodyJson = null;
			JSONObject payloadJson = null;
			// 'body' key is under 'payload', so build a 'payload' if it doesn't exist
			if (baseJson.has("payload")) {
				payloadJson = baseJson.getJSONObject("payload");
			} else {
				payloadJson = new JSONObject();
				baseJson.put("payload", payloadJson);
			}
			// Get 'body' JSONObject, generate one if not existed
			if (payloadJson.has("body")) {
				bodyJson = payloadJson.getJSONObject("body");
			} else {
				bodyJson = new JSONObject();
				payloadJson.put("body", bodyJson);
			}
			bodyJson.put(key, value);
		} else {
			if (key == "payload" || key == "body" || key == "policy" || key == "extra") {
				throw new Exception("You don't need to set value for " + key + " , just set values for the sub keys in it.");
			} else {
				throw new Exception("Unknown key: " + key);
			}
		}
		return true;
	}
	
}
