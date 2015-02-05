package com.cp.account;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cp.JDBC.SelectOperation;

public class SelectAccount {
	
	public static ResultSet selectAccount(String accountType){
		ResultSet rs = SelectOperation.selectOnes("select ID as id ,userName,showTime,operation from account where type like '%"+accountType+"%' order by ID desc limit 0,20");
		return rs;
	}
	
	public static ResultSet selectAccount(int id){
		List<Object> list = new ArrayList<>();
		list.add(id);
	    ResultSet rs = SelectOperation.selectOne("select passwd from account where ID = ?", list);	
	    return rs;
	}
	
	public static ResultSet selectAccount(String accountType, String pageNum){
		ResultSet rs = SelectOperation.selectOnes("select ID as id ,userName,showTime,operation from account where type like '%"+accountType+"%' order by ID desc limit "+Integer.valueOf(pageNum)*20+",20");
		return rs;
	}

}
