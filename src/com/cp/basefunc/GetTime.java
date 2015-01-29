/**
 * TODO
 * 2015年1月22日
 * com.cp.basefunc
 */
package com.cp.basefunc;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Jerry
 *
 */
public class GetTime {
	
	private String onlyDate;
	private String dateAndTime;
	private String onlyTime;
	
	
	/**
	 * 
	 */
	public GetTime() {
		Date date = new Date();
		this.onlyDate = (new SimpleDateFormat("yyyyMMdd")).format(date);
		this.dateAndTime = (new SimpleDateFormat("yyyyMMddHHmmss")).format(date);
		this.onlyTime = (new SimpleDateFormat("HHmmss")).format(date);
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetTime getTime = new GetTime();
		System.out.println(getTime.dateAndTime);
	}
	
	public static String getPageDate() {
		return (new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	}
	/**
	 * 仅仅获取日期
	 * @return the onlyDate
	 */
	public String getOnlyDate() {
		return onlyDate;
	}

	/**
	 * 获取时间精确到秒
	 * @return the dateAndTime
	 */
	public String getDateAndTime() {
		return dateAndTime;
	}
	
}
