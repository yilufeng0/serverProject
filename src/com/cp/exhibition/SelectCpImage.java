package com.cp.exhibition;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cp.JDBC.SelectOperation;

public class SelectCpImage {
	public static ResultSet selectCpImage(){
		ResultSet rs = SelectOperation.selectOnes("select ID as id,showTime,thumbpath,description from exhibition order by ID desc limit 0,20");
		return rs;
	}
	
	public static ResultSet selectCpImage(int id){
		List<Object> list = new ArrayList<>();
		list.add(id);
		ResultSet rs = SelectOperation.selectOne("select oripath from exhibition where ID =?",list);
		return rs;
	}
	
	public static ResultSet selectCpImage(String pageNum){
		ResultSet rs = SelectOperation.selectOnes("select ID as id,time,thumbpath,description from exhibition order by ID desc limit "+Integer.valueOf(pageNum)*20+",20");
		return rs;
	}

}
