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
import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

/**
 * @author Jerry
 *
 */
public class SelectOperation {
	private static Connection conn=null;
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
			conn = JDBCConnect.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
			return null;
		}		
		return rs;		
	}
	
	public static ResultSet selectOne(String sql,List<Object> param){
		ResultSet rs = null;
		try {
			conn = JDBCConnect.getConnection();
			pstm = conn.prepareStatement(sql);
			for(int i =0;i<param.size();i++){
				set(i+1, param.get(i));
			}
			rs=pstm.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return rs;
	}
	public static ResultSet selectOne(String sql,int id){
		ResultSet rs = null;
		try {
			conn = JDBCConnect.getConnection();
			pstm=conn.prepareStatement(sql);
			set(1, id);
			rs=pstm.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception			
			return null;
		}		
		return rs;
	}
	
	/**
	 * @param index 指示所填充的位置 
	 * @param obj	在指示位置填充的数据
	 * @throws SQLException 
	 */
	private static void set(int index,Object obj) throws SQLException{
		String valType=obj.getClass().getSimpleName();
		switch (valType) {
		case "String":
			pstm.setString(index, (String)obj);
			//System.out.println("string");
			break;
		case "Integer":
			pstm.setInt(index, (int)obj);
			//System.out.println("int");
			break;
		default:
			break;
		}
	}
	
	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		List<Object> list= new ArrayList<>();
		list.add(6);
		ResultSet rs= SelectOperation.selectOne("select *  from position_shop where id = ?",list);
		rs.next();
		System.out.println(rs.getString("cityname"));
		
	}

}
