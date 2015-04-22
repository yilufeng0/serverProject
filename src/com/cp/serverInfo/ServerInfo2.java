package com.cp.serverInfo;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;   

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;

import com.sun.management.OperatingSystemMXBean;

public class ServerInfo2 {
	
///////////////////////////////////////////内存信息////////////////////////////////		
	/**
	 * 获取服务器物理内存使用率(%)
	 * @return String类型（小数点后两位）的内存使用率
	 */
	public String getMemUsageRatio() {  		
		 double total = 0d;
	     double free = 0d;
	     double usage = 0d;
	     OperatingSystemMXBean osmb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean(); 
	     total = osmb.getTotalPhysicalMemorySize();
	     free = osmb.getFreePhysicalMemorySize();
	     usage = total - free;
	     return doubleFormat((usage/total)*100);   
	    
	}
	
///////////////////////////////////////////硬盘信息////////////////////////////////		
	/**
	 * 获取服务器本地硬盘总量(GB)
	 * @return String类型（小数点后两位）的硬盘总量
	 */
	public String getDiskAll() {  
		 File[] roots = File.listRoots();
	     double constm = 1024 * 1024 * 1024 ;
	     double total = 0d;
	     for(File _file : roots){
	    	 total+=_file.getTotalSpace();
	     }
	     return doubleFormat(total/constm);
	}  
	
	
	/**
	 * 获取服务器本地硬盘使用率(%)
	 * @return String类型（小数点后两位）的硬盘使用率
	 */
	public String getDiskRatio(){
		 File[] roots = File.listRoots();
	     double total = 0d;
	     //double constm = 1024 * 1024 * 1024 ;
	     double free = 0d;
	     double usage = 0d;
	     for(File _file : roots){
	    	 free+=_file.getFreeSpace();
	    	 total+=_file.getTotalSpace(); 
	     }
	     usage = total-free; 
        // System.out.println(usage/constm);
	     double tmp = usage/total; 
         return doubleFormat(tmp*100);  //硬盘使用百分率%
	}

    /**
     * @param d 待转换的double数字
     * @return  格式化后的字符串
     */
    public String doubleFormat(double d){   
        DecimalFormat df = new DecimalFormat("0.##");   
        return df.format(d);                   
    }
    
///////////////////////////////////////////操作系统信息////////////////////////////////	
    
    // 获取当前操作系统名称描述  
	public String getOsDesc(){
		Properties props=System.getProperties();
		String osName = props.getProperty("os.name"); //操作系统名称 
		return  osName;
	}
	
	// 操作系统类型 (32bit/64bit) 
	public String getOsType(){
		Properties props=System.getProperties();
		String osArch = props.getProperty("os.arch"); //操作系统构架
		return osArch;
	}
	
	//获取当前操作系统的版本号  
	public String getOsVersion(){
		Properties props=System.getProperties();
		String osVersion = props.getProperty("os.version"); //操作系统版本   
		return osVersion;
	}
	
	
///////////////////////////////////////////网络信息////////////////////////////////		
//获取当前机器的IP地址()
//	public String getIpAddr() {  	
//	String address = null;
//	try {
//		String addresstmp = InetAddress.getLocalHost().toString();
//		address = addresstmp.substring(addresstmp.indexOf("/")+1, addresstmp.length());
//	} catch (UnknownHostException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return address;		  
//	} 

//获取当前机器的IP地址(通过web.xml配置文件获取)
	public String getIpAddr(){
//		Map<String, String> map = new HashMap<String, String>() ;   ServletConfig config
//		map.put("ip", config.getInitParameter("IP"));
//		map.put("port", config.getInitParameter("PORT"));
		String ipAddress = null;
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			ipAddress = (String)envCtx.lookup("IP");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ipAddress;
	}
	
//获取当前机器的IP地址(通过web.xml配置文件获取)
	public String getPort(){
		String port = null;
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			port = (String)envCtx.lookup("PORT");
			System.out.println(port);
		} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} 
			return port;
		}

	public static void main(String[] args) throws UnknownHostException {
//		System.out.println(new ServerInfo2().getOsDesc());
//		System.out.println(new ServerInfo2().getOsVersion());
//		System.out.println(new ServerInfo2().getOsType());
//		System.out.println(new ServerInfo2().getDiskRatio());
	
    }
     

}
