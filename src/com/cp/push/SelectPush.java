package com.cp.push;

import java.sql.ResultSet;

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
}