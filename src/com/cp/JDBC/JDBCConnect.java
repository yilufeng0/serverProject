/**
 * 
 */
package com.cp.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author Jerry
 *
 */
public class JDBCConnect {
	static String drivername="com.mysql.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/serverProject";
	static String username="root";
	static String password="root";
	
	static{
		try {
			Class.forName(drivername);
			System.out.println("load driver success");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		}
	}
	
	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn=(Connection)DriverManager.getConnection(url, username, password);
			System.out.println("connect DB success");
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("fail,check url/username/password");
			e.printStackTrace();
		}
		return conn;
	}
	
	public JDBCConnect() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		JDBCConnect.getConnection();
		
	}
	
	public static void  free(ResultSet rs,Connection conn,Statement stmt) {
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("close ResultSet fail!");
			e.printStackTrace();
		}finally{
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println("close connection fail");
				e2.printStackTrace();
			}finally{
				try {
					if(stmt!= null){
						stmt.close();
					}
				} catch (SQLException e3) {
					// TODO: handle exception
					System.out.println("clost statement fail");
					e3.printStackTrace();
				}
			}
		}
	}
	
	
	public static void  free(ResultSet rs,Connection conn,PreparedStatement pstm) {
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("close ResultSet fail!");
			e.printStackTrace();
		}finally{
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println("close connection fail");
				e2.printStackTrace();
			}finally{
				try {
					if(pstm!= null){
						pstm.close();
					}
				} catch (SQLException e3) {
					// TODO: handle exception
					System.out.println("clost statement fail");
					e3.printStackTrace();
				}
			}
		}
	}
	
}
