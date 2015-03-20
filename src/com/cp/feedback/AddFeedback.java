package com.cp.feedback;

import java.util.ArrayList;
import java.util.List;

import com.cp.JDBC.InsertOperation;

public class AddFeedback {
	public static void addFeedback(String feedback,String uuId,String telephone){
		List<Object> list = new ArrayList<>();
		list.add(feedback);
		list.add(uuId);
		list.add(telephone);
		String sql = "insert into feedback (feedback,uuId,telephone) values(?,?,?)";
		InsertOperation.insertOne(sql, list);
	}

}
