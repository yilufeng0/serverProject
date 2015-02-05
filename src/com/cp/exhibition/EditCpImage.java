package com.cp.exhibition;

import java.util.ArrayList;
import java.util.List;

import com.cp.JDBC.UpdateOperation;

public class EditCpImage {
	public static boolean editCpImage(int id, String discription){
		String sql = "update exhibition set description =? where ID = ?";
		List<Object> updateList = new ArrayList<>();
		updateList.add(discription);
		updateList.add(id);
		return UpdateOperation.UpdateOne(sql, updateList);	
	}


}
