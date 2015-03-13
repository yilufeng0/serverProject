package com.cp.newspub;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cp.JDBC.SelectOperation;

public class SelectNews {

	public static ResultSet selectNews(){
		ResultSet rs = SelectOperation.selectOnes("select ID as id ,title,author,showTime from news order by ID desc limit 0,20");
		return rs;
	}
	
	public static ResultSet selectNews(int id){
		List<Object> list = new ArrayList<>();
		list.add(id);
	    ResultSet rs = SelectOperation.selectOne("select content from news where ID = ?", list);	
	    return rs;
	}
	
	public static ResultSet selectNewsInfo(String uuid){
		List<Object> list = new ArrayList<>();
		list.add(uuid);
	    ResultSet rs = SelectOperation.selectOne("select content,imageThumbnail from news where uuid = ?", list);	
	    return rs;
	}
	
	public static ResultSet selectNews(String pageNum){
		ResultSet rs = SelectOperation.selectOnes("select ID as id ,title,author,showTime from news order by ID desc limit "+Integer.valueOf(pageNum)*20+",20");
		return rs;
	}

	public static ResultSet selectNewsImg(){
		ResultSet rs = SelectOperation.selectOnes("select ID as id,imageThumbnailUrl as smallUrl from news order by ID desc");
		return rs;
	}
	
	public static ResultSet selectNewsText(){
		ResultSet rs = SelectOperation.selectOnes("select ID as id,contentUrl from news order by ID desc");
		return rs;
	}
}
