package com.cp.basefunc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cp.newspub.SelectNews;
import com.mysql.jdbc.ResultSetMetaData;

public class ResultsetToJSON {
	
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
