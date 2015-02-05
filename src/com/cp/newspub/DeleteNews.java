package com.cp.newspub;

import com.cp.JDBC.DeleteOperation;

public class DeleteNews {
	public static boolean deleteNews(int id){
		String sql = "delete from news where ID = ?";
		return DeleteOperation.deleteOne(sql, id);	
	}
}
