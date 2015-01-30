/**
 * TODO
 * 2015年1月29日
 * account
 */
package com.cp.account;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cp.JDBC.SelectOperation;

/**
 * @author Jerry
 *
 */
public class AccountAuth {
	
	public boolean AccountLogin(String userName,String passwd){
		boolean result = true;
		String sql = "select count(*) as result from account where userName=? and passwd=? ";
		List<Object> list = new ArrayList<>();
		list.add(userName);
		list.add(passwd);
		try {
			ResultSet rs = SelectOperation.selectOne(sql, list);
			rs.next();
			int tmp = rs.getInt("result");
			if(tmp==0){
				result = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			result = false;
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 boolean result = new AccountAuth().AccountLogin(null, null);
	 System.out.println(result);
	}

}
