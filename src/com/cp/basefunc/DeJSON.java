package com.cp.basefunc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 将JSON数据进行解析
 * @author zjd
 *
 */
public class DeJSON {
	/**
	 * @param jSON 待解析的JSON数据
	 * @param key  JSON中键值对的键
	 * @return     JSON中键值对的值
	 * @throws JSONException
	 */
	public static ArrayList<String[]> deJSON(String jSON,List<String> key) throws JSONException{
		JSONArray jsonArray = new JSONArray(jSON);
		int arrayLen = jsonArray.length();
		int columnLen = key.size();
		ArrayList<String[]> valList = new ArrayList<String[]>();
		for(int i=0;i<arrayLen;i++){
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			for(int j=0;j<columnLen;j++){
			//	String[] temp = valList.get(i);
			//	 temp = new String[columnLen];
			//	 temp[j] = jsonObj.get(key.get(j)).toString();
			//	System.out.println(temp[j]);
			}
		}
		return valList;
	}
	
	public static void main(String[] args) throws JSONException {
		ArrayList<String[]> a = new ArrayList<String[]>();
		String jSON = "[{'a':'1','spsl':'2'},{'a':'2','spsl':'2'},{'a':'3','spsl':'4'}]";
		List<String> key= Arrays.asList("a","spsl");
		a = DeJSON.deJSON(jSON, key);
	//	System.out.println(a.get(0));
	}

}
