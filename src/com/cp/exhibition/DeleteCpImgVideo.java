package com.cp.exhibition;

import com.cp.JDBC.DeleteOperation;

public class DeleteCpImgVideo {
	public static boolean deleteCpImage(int id){
		String sql = "delete from exhibition where ID = ?";
		return DeleteOperation.deleteOne(sql, id);	
	}
}
