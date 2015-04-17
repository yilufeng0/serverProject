package com.cp.feedback;

import java.util.ArrayList;
import java.util.List;

import com.cp.JDBC.InsertOperation;

public class AddFeedback {
	public static void addFeedback(String feedback,String uuId,String telephone,String time){
		List<Object> list = new ArrayList<>();
		list.add(feedback);
		list.add(uuId);
		list.add(telephone);
		list.add(time);
		
		String sql = "insert into feedback (feedback,uuId,telephone,showTime) values(?,?,?,?)";
		InsertOperation.insertOne(sql, list);
	}

}
