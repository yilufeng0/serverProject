package com.cp.push;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

public class BaseNotification {
	protected JSONObject baseJson = new JSONObject();
	protected CloseableHttpClient client = HttpClients.createDefault();
	//设置推送通知的基本键参数
	protected static final HashSet<String> BASE_KEYS = new HashSet<String>(Arrays.asList(new String[]
			{"appkey","timestamp","type","device_tokens","production_mode","description"}));
	protected static final String host = "http://msg.umeng.com";
	protected static final String postPath = "/api/send";
	protected String appMasterSecret;
	
    /**
     * 设置appMasterSecret参数，用于MD5签名验证
     * @param secret  传入appMasterSecret值
     */
    public void setAppMasterSecret(String secret){
    	appMasterSecret = secret;
    }
    /**
     * 实现将消息POST出去，并获得返回参数的功能
     * @return 推送成功，返回真值
     * @throws Exception
     */
    public boolean sendPush() throws Exception {
        String url = host + postPath;
        String postBody = baseJson.toString();
        String sign = DigestUtils.md5Hex("POST" + url + postBody + appMasterSecret);
        url = url + "?sign=" + sign;
        HttpPost post = new HttpPost(url);
        StringEntity se = new StringEntity(postBody, "UTF-8");
        post.setEntity(se);
        // Send the post request and get the response
        HttpResponse response = client.execute(post);
        int status = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + status);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line = null;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println(result.toString());
        if (status == 200) {
            System.out.println("Notification sent successfully.");
        } else {
            System.out.println("Failed to send the notification!");
        }
        return true;
    }
}
