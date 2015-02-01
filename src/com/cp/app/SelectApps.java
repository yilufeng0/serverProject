package com.cp.app;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cp.JDBC.SelectOperation;

public class SelectApps {
	public static ResultSet selectApps(String appType){
		ResultSet rs = SelectOperation.selectOnes("select ID as id ,title,time,bigVersion,mediumVersion,smallVersion from apps where type like '%"+appType+"%' order by ID desc limit 0,20");
		return rs;
	}
	
	public static ResultSet selectApps(int id){
		List<Object> list = new ArrayList<>();
		list.add(id);
	    ResultSet rs = SelectOperation.selectOne("select ID as id where ID = ?", list);	
	    return rs;
	}
	
	public static ResultSet selectApps(String appType, String pageNum){
		ResultSet rs = SelectOperation.selectOnes("select ID as id ,title,time,bigVersion,mediumVersion,smallVersion from apps where type like '%"+appType+"%' order by ID desc limit "+Integer.valueOf(pageNum)*20+",20");
		return rs;
	}

}
