package com.cp.basefunc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.mysql.jdbc.ResultSetMetaData;

/**
 * 将数据库查询的结果集转换为JSON数据格式
 * @author zjd
 *
 */
public class ResultsetToJSON {
	
	/**
	 * @param rs 数据库查询的结果集
	 * @return   转换后的字符串格式的JSON数据
	 * @throws SQLException
	 * @throws JSONException
	 */
	public static String resultsetToJSON(ResultSet rs) throws SQLException, JSONException{
		JSONArray jsonArray = new JSONArray();
		ResultSetMetaData rsMetaData = (ResultSetMetaData) rs.getMetaData();
		int columnCount = rsMetaData.getColumnCount();
			while(rs.next()){
				JSONObject jsonObj = new JSONObject();
				for(int i = 1; i <=columnCount; i++){
					String columnName = rsMetaData.getColumnLabel(i);
					Object value = rs.getObject(columnName);
					jsonObj.put(columnName,value);	
				}
				jsonArray.put(jsonObj);
			}
			return jsonArray.toString();	
	}
	
	public static void main(String[] args) throws SQLException, JSONException {
		
	}

}
