package com.cp.feedback;

import java.sql.ResultSet;

import com.cp.JDBC.SelectOperation;

public class SelectFeedback {
	public static ResultSet selectFeedback(){
		ResultSet rs = SelectOperation.selectOnes("select ID as id ,time,feedback from feedback order by ID desc limit 0,20");
		return rs;
	}

}
