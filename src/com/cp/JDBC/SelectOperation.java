/**
 * TODO
 * 2015年1月20日
 * com.cp.JDBC
 */
package com.cp.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jerry
 *
 */
public class SelectOperation {
	private static Connection conn=JDBCConnect.getConnection();
	private static PreparedStatement pstm =null;
	private static Statement stmt=null;
	
	/**
	 * 完成数据的查询操作
	 * @param sql
	 * @return
	 */
	public static ResultSet selectOnes(String sql){
		ResultSet rs=null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JDBCConnect.free(rs, conn, stmt);
			return null;
		}
		JDBCConnect.free(null, conn, stmt);
		return rs;		
	}
	
	
	public static ResultSet selectOne(String sql,int id){
		ResultSet rs = null;
		try {
			pstm=conn.prepareStatement(sql);
			set(1, id);
			rs=pstm.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			JDBCConnect.free(rs, conn, pstm);
			return null;
		}
		JDBCConnect.free(null, conn, pstm);
		return rs;
	}
	
	/**
	 * @param index 指示所填充的位置 
	 * @param obj	在知识位置填充的数据
	 * @throws SQLException 
	 */
	private static void set(int index,Object obj) throws SQLException{
		String valType=obj.getClass().getSimpleName();
		switch (valType) {
		case "String":
			pstm.setString(index, (String)obj);
			System.out.println("string");
			break;
		case "Integer":
			pstm.setInt(index, (int)obj);
			System.out.println("int");
			break;
		default:
			break;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
