package com.cp.account;

import com.cp.JDBC.DeleteOperation;

public class DeleteAccount {
	public static boolean deleteAccount(int id){
		String sql = "delete from account where ID = ?";
		return DeleteOperation.deleteOne(sql, id);	
	}
}
