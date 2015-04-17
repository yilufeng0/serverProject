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
	    ResultSet rs = SelectOperation.selectOne("select content,title,abstract,showTime from news where uuid = ?", list);	
	    return rs;
	}
	
	public static ResultSet selectNews(String pageNum){
		ResultSet rs = SelectOperation.selectOnes("select ID as id ,title,author,showTime from news order by ID desc limit "+Integer.valueOf(pageNum)*20+",20");
		return rs;
	}

	public static ResultSet selectNewsItem(String id){
		ResultSet rs = SelectOperation.selectOnes("select ID as id,title,showTime as showtime,abstract,imageThumbnailUrl as smallUrl,contentUrl,uuid from news where id >"+Integer.valueOf(id)+" order by ID desc");
		//ResultSet rs = SelectOperation.selectOnes("select uuid from news where id >"+Integer.valueOf(id)+" order by ID desc");
		return rs;
	}
	
}
