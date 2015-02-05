package com.cp.account;

import java.util.ArrayList;
import java.util.List;

import com.cp.JDBC.UpdateOperation;

public class EditAccount {
	public static boolean editAccount(int id, String renewpasswd){
		String sql = "update account set passwd = ? where ID = ?";
		List<Object> updateList = new ArrayList<>();
		updateList.add(renewpasswd);
		updateList.add(id);
		return UpdateOperation.UpdateOne(sql, updateList);	
	}

}
