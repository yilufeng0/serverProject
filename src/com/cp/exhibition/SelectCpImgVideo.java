package com.cp.exhibition;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cp.JDBC.SelectOperation;

public class SelectCpImgVideo {
	public static ResultSet selectCpImgVideo(){
		ResultSet rs = SelectOperation.selectOnes("select ID as id,type,showTime,thumbpath,oripath,Url,description from exhibition order by ID desc limit 0,20");
		return rs;
	}
	
	public static ResultSet selectCpImgVideo(int id){
		List<Object> list = new ArrayList<>();
		list.add(id);
		ResultSet rs = SelectOperation.selectOne("select oripath from exhibition where ID =?",list);
		return rs;
	}
	
	public static ResultSet selectCpImgVideo(String cpType,String pageNum){
		ResultSet rs = SelectOperation.selectOnes("select ID as id,showTime,type,oripath,Url,thumbpath,description from exhibition where type like '%"+cpType+"%' order by ID desc limit "+Integer.valueOf(pageNum)*20+",20");
		return rs;
	}

	public static ResultSet selectExhibition(){
		ResultSet rs = SelectOperation.selectOnes("select ID as uid,type as type,Url as url from exhibition order by ID desc");
		return rs;
	}
	
}
