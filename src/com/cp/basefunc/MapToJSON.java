package com.cp.basefunc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * 将HashMap数据转换为JSON数据格式
 * @author DELL
 *
 */
public class MapToJSON {

	 /**
	 * 将HashMap数据转换为JSON数据格式
	 * @param map 待转换的HashMap数据
	 * @return
	 */
	public static String hashMapToJson(HashMap map) {
		 String string = "{";  
	        for (Iterator it = map.entrySet().iterator(); it.hasNext();) {  
	            Entry e = (Entry) it.next();  
	            string += "'" + e.getKey() + "':";  
	            string += "'" + e.getValue() + "',";  
	        }  
	        string = string.substring(0, string.lastIndexOf(","));  
	        string += "}";  
	        return string;  
	 }
	 
	 public static void main(String[] args) {
/*		HashMap<String,String> map = new HashMap<String,String>();  
		map.put("result", "1");
	    map.put("isUpdate","2");
		String json = MapToJSON.hashMapToJson(map);
		System.out.println(json); */
	}
}
