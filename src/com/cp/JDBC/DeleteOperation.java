/**
 * TODO
 * 2015年1月20日
 * com.cp.JDBC
 */
package com.cp.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * 完成数据库中数据的删除工作
 * @author Jerry
 *
 */
public class DeleteOperation {
	
	private static Connection conn = JDBCConnect.getConnection();
	private static PreparedStatement pstm = null;
	private static Statement stmt = null;
	/**
	 * 完成删除某几条的功能
	 * @param sql 要执行的删除语句
	 * @param param  与删除语句相对应的数据
	 * @return 返回数据操作的结果
	 */
	public static boolean deleteOne(String sql,List<Object> param){
		if (param.size()<=0) {
			return false;
		}
		try {
			 pstm=conn.prepareStatement(sql);
			for (int i = 0; i < param.size() ; i++) {
				set(i+1, param.get(i));
			}
			pstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			JDBCConnect.free(null, conn, pstm);
			return false;
		}
//		JDBCConnect.free(null, conn, pstm);
		return true;
	}
	
	/**
	 * 完成通过id进行的删除操作
	 * @param sql
	 * @param param
	 * @return
	 */
	public static boolean deleteOne(String sql,int id){
		
		try {
			 pstm=conn.prepareStatement(sql);			
			 pstm.setInt(1, id);			
			 pstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			JDBCConnect.free(null, conn, pstm);
			return false;
		}
//		JDBCConnect.free(null, conn, pstm);
		return true;
	}
	public static boolean deleteones(String sql){
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			JDBCConnect.free(null, conn, stmt);
			return false;
		}
//		JDBCConnect.free(null, conn, stmt);		
		return true;
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
			break;
		case "Integer":
			pstm.setInt(index, (int)obj);
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
