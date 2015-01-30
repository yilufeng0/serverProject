package com.cp.newspub;

import java.sql.ResultSet;

import com.cp.JDBC.SelectOperation;

public class SelectNews {
	
	public static ResultSet selectNews(){
		ResultSet rs = SelectOperation.selectOnes("select ID as id ,title,author,time from news order by ID desc limit 0,20");
		return rs;
	}

}
