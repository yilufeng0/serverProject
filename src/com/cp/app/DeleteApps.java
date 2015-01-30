package com.cp.app;

import com.cp.JDBC.DeleteOperation;

public class DeleteApps {
	public boolean deleteApp(int id){
		String sql = "delete from apps where ID = ?";
		return DeleteOperation.deleteOne(sql, id);	
	}

}
