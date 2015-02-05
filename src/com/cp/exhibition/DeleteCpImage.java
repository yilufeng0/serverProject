package com.cp.exhibition;

import com.cp.JDBC.DeleteOperation;

public class DeleteCpImage {
	public static boolean deleteCpImage(int id){
		String sql = "delete from exhibition where ID = ?";
		return DeleteOperation.deleteOne(sql, id);	
	}
}
