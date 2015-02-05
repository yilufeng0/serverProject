package com.cp.newspub;

import java.util.ArrayList;
import java.util.List;

import com.cp.JDBC.UpdateOperation;

public class EditNews {
	public static boolean editNews(int id, String content){
		String sql = "update news set content =? where ID = ?";
		List<Object> updateList = new ArrayList<>();
		return UpdateOperation.UpdateOne(sql, updateList);	
	}

}
