package com.cp.push;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cp.JDBC.SelectOperation;

public class SelectPush {

	public static ResultSet selectPush(){
		ResultSet rs = SelectOperation.selectOnes("select ID as id ,tips,title,abstract from push order by ID desc limit 0,20");
		return rs;
	}
	
	public static ResultSet selectPush(String pageNum){
		ResultSet rs = SelectOperation.selectOnes("select ID as id,tips,title,abstract from push order by ID desc limit "+Integer.valueOf(pageNum)*20+",20");
		return rs;
	}
	
	public static ResultSet selectPushInfo(String uuid){
		List<Object> list = new ArrayList<>();
		list.add(uuid);
	    ResultSet rs = SelectOperation.selectOne("select content,title from push where uuid = ?", list);	
	    return rs;
	}
}
