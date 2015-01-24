package com.cp.serverInfo;

import java.io.*;
import java.util.*;
//import com.sun.management.*;
import java.net.*;

import org.hyperic.sigar.*;

public class ServerInfo {
	
	private Sigar sigar=null;
	public ServerInfo(){
		this.sigar= new Sigar();
	}
	
    //获取服务器物理内存总量(GByte)
	public float getMemoryAll() throws SigarException{
		sigar = new Sigar();
		Mem mem = null;
		mem = sigar.getMem();
		float a = (float)mem.getTotal()/1024/1024/1024;   //内存单位为GByte
		float b = (float)(Math.round(a*100))/100;   //保留小数点后两位
		return b;
	}
	
	//获取服务器物理内存使用率(%)
	public float getMemUsageRatio() throws SigarException{
		sigar = new Sigar();
		Mem mem = null;
		mem = sigar.getMem();
		float a = (float)mem.getUsedPercent();  //内存使用率%
		float b = (float)(Math.round(a*100))/100;   //保留小数点后两位
		return b;
	}
	
	//获取服务器本地硬盘总量(GByte)
	public float getDiskAll() throws SigarException{
		sigar = new Sigar();  
		FileSystem fslist[] = sigar.getFileSystemList();  
		long total = 0L;
		for (int i = 0; i < fslist.length; i++) {  
		FileSystem fs = fslist[i];  
	    FileSystemUsage usage = null;  
		   try {  
		    usage = sigar.getFileSystemUsage(fs.getDevName());  
		   } catch (SigarException e) {  
		   }  
		   if(fs.getTypeName().equals("local"))
		   {
		    //文件系统总量
		    total = total + usage.getTotal();
		   }
		}
          return total/1024/1024;
	}
	
	//获取服务器本地硬盘使用率(%)
	public float getDiskRatio() throws SigarException{
		sigar = new Sigar();  
		FileSystem fslist[] = sigar.getFileSystemList();  
		long total = 0L;
		long use = 0L;
		for (int i = 0; i < fslist.length; i++) {  
		FileSystem fs = fslist[i];  
	    FileSystemUsage usage = null;  
		   try {  
		    usage = sigar.getFileSystemUsage(fs.getDevName());  
		   } catch (SigarException e) {  
		   }  
		   if(fs.getTypeName().equals("local"))
		   {
		    //文件系统总量
		    total = total + usage.getTotal();
		    //文件系统已使用量  
		    use = use + usage.getUsed();
		   }
		}
		  float tmp = (float)use/total;
		  float diskUsedPercent = (float)(Math.round(tmp*100))/100;   ///服务器本地硬盘使用率
          return diskUsedPercent*100;  //硬盘使用百分率%
	}
	
	//获取当前机器的IP地址
	public String getIpAddr() {  	
	    String address = null;  
		try {  
		   address = InetAddress.getLocalHost().getHostAddress();  
		   // 没有出现异常而正常获得IP时，如果取到的不是网卡循回地址时就返回 此IP 
		   // 否则再通过Sigar包中的方法来获取  
		 if (!NetFlags.LOOPBACK_ADDRESS.equals(address)) {  
		    return address;  
		   }  
		  } catch (UnknownHostException e) {  
		   // hostname not in DNS or /etc/hosts  
		  } 
		  Sigar sigar = new Sigar();  
		  try {  
			   address = sigar.getNetInterfaceConfig().getAddress();  
			  } catch (SigarException e) {  
			   address = NetFlags.LOOPBACK_ADDRESS;  
			  } finally {  
			   sigar.close();  
			  }  
			  return address;		  
	 }  


		  
	 // 获取当前操作系统名称描述  
	public String getOsDesc(){
		 OperatingSystem OS = OperatingSystem.getInstance();  
		 return OS.getDescription();
	}
	
	// 操作系统类型 (32bit/64bit) 
	public String getOsType(){
		 OperatingSystem OS = OperatingSystem.getInstance();  
		 return OS.getName();
	}
	
	//获取当前操作系统的版本号  
	public String getOsVersion(){
		 OperatingSystem OS = OperatingSystem.getInstance();  
		 return OS.getVersion();
	}

}
