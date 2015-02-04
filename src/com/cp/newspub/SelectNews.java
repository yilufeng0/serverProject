package com.cp.newspub;

import java.sql.ResultSet;

import com.cp.JDBC.SelectOperation;

public class SelectNews {

	public static ResultSet selectNews(){
		ResultSet rs = SelectOperation.selectOnes("select ID as id ,title,author,showTime from news order by ID desc limit 0,20");
		return rs;
	}
	
	public static ResultSet selectNews(String pageNum){
		ResultSet rs = SelectOperation.selectOnes("select ID as id ,title,author,showTime from news order by ID desc limit "+Integer.valueOf(pageNum)*20+",20");
		return rs;
	}

}
