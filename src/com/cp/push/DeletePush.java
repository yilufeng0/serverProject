package com.cp.push;

import com.cp.JDBC.DeleteOperation;

public class DeletePush {
	public static boolean deletePush(int id){
		String sql = "delete from push where ID = ?";
		return DeleteOperation.deleteOne(sql, id);	
	}

}
