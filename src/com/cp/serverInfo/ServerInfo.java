package com.cp.serverInfo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.NetFlags;
import org.hyperic.sigar.NetInterfaceConfig;
import org.hyperic.sigar.NetInterfaceStat;
import org.hyperic.sigar.OperatingSystem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class ServerInfo {
	
	private Sigar sigar=null;
	public ServerInfo(){
		this.sigar= new Sigar();
	}
///////////////////////////////////////////内存信息////////////////////////////////	
    //获取服务器物理内存总量(GByte)
	public float getMemoryAll() throws SigarException{
		Mem mem = null;
		mem = sigar.getMem();
		float a = (float)mem.getTotal()/1024/1024/1024;   //内存单位为GByte
		float b = (float)(Math.round(a*100))/100;   //保留小数点后两位
		return b;
	}
	
	//获取服务器物理内存使用率(%)
	public float getMemUsageRatio(){
		Mem mem = null;
		float a =0;
		float b =0;
		try {
			mem = sigar.getMem();
			 a = (float)mem.getUsedPercent();  //内存使用率%
			 b = (float)(Math.round(a*100))/100;   //保留小数点后两位
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
///////////////////////////////////////////硬盘信息////////////////////////////////		
	//获取服务器本地硬盘总量(GByte)
	public float getDiskAll(){  
		long total = 0L;
	    FileSystemUsage usage = null;  
	    try {
	    	FileSystem fslist[] = sigar.getFileSystemList(); 
			for (int i = 0; i < fslist.length; i++) {  
		    	FileSystem fs = fslist[i];  
			    usage = sigar.getFileSystemUsage(fs.getDevName());  
			   if(fs.getTypeName().equals("local"))
			   {
			    //文件系统总量
			    total = total + usage.getTotal();
			   }
			}	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
          return total/1024/1024;
	}
	
	//获取服务器本地硬盘使用率(%)
	public float getDiskRatio(){ 
		long total = 0L;
		long use = 0L;
		try {
			FileSystem fslist[] = sigar.getFileSystemList();  
			for (int i = 0; i < fslist.length; i++) {  
			FileSystem fs = fslist[i];  
		    FileSystemUsage usage = null;  
	        usage = sigar.getFileSystemUsage(fs.getDevName());  
			   if(fs.getTypeName().equals("local"))
			   {
			    //文件系统总量
			    total = total + usage.getTotal();
			    //文件系统已使用量  
			    use = use + usage.getUsed();
			   }
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		  float tmp = (float)use/total;
		  float diskUsedPercent = (float)(Math.round(tmp*100))/100;   ///服务器本地硬盘使用率
          return diskUsedPercent*100;  //硬盘使用百分率%
	}
	
///////////////////////////////////////////CPU信息////////////////////////////////		
	//获取服务器CPU的总量GHz 
	public float getCpuTotal() throws SigarException{
		CpuInfo[] infos = sigar.getCpuInfoList();
		CpuInfo info = infos[0];
		float tmp = (float)info.getMhz()/1024;
		float cpuInfo = (float)(Math.round(tmp*100))/100;
		return cpuInfo;
	}
	
	//获取服务器CPU的总(用户+系统)使用率(%)
	public String getCpuRatio() throws SigarException{
		CpuPerc cpu = sigar.getCpuPerc();
		return CpuPerc.format(cpu.getCombined()); //总的使用率 
	}
	
///////////////////////////////////////////网络信息////////////////////////////////		
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

	//获取所有网卡接收的总包裹数
	public long getRxPackets() throws SigarException{
		String Names[] = sigar.getNetInterfaceList();  
		long rxPackets = 0L;
		
		for (int i = 0; i < Names.length; i++) {  
		    String name = Names[i];  
		    NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name); 
		    if ((ifconfig.getFlags() & 1L) <= 0L) {    //IFF_UP...skipping getNetInterfaceStat
		        continue;  
		    }  
		    try {  
		        NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);  
		        rxPackets = rxPackets + ifstat.getRxPackets();  // 计算所有网卡接收的总包裹数  		    
		    } catch (SigarException e) {  
		    	System.out.println(e.getMessage());  
		    }  
		
		}  
		
		return rxPackets;
		
	} 
	
	//获取所有网卡发送的总包裹数
		public long getTxPackets() throws SigarException{
			String Names[] = sigar.getNetInterfaceList();  
			long txPackets = 0L;

			for (int i = 0; i < Names.length; i++) {  
			    String name = Names[i];  
			    NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name); 
			    if ((ifconfig.getFlags() & 1L) <= 0L) {    //IFF_UP...skipping getNetInterfaceStat
			        continue;  
			    }  
			    try {  
			        NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);  
			        txPackets = txPackets + ifstat.getTxPackets();  // 计算所有网卡发送的总包裹数   
			    } catch (SigarException e) {  
			    	System.out.println(e.getMessage());  
			    }  	
			}  
			
			return txPackets;		
	} 
	
	
		//获取所有网卡接收的总字节数
		public long getRxBytes() throws SigarException{
			String Names[] = sigar.getNetInterfaceList();  
			long rxBytes = 0L;
			
			for (int i = 0; i < Names.length; i++) {  
			    String name = Names[i];  
			    NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name); 
			    if ((ifconfig.getFlags() & 1L) <= 0L) {    //IFF_UP...skipping getNetInterfaceStat
			        continue;  
			    }  
			    try {  
			        NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);   
			        rxBytes = rxBytes + ifstat.getRxBytes();      // 计算所有网卡接收到的总字节数  
			    } catch (SigarException e) {  
			    	System.out.println(e.getMessage());  
			    }  
			
			}  
			
			return rxBytes;			
	} 
	
		//获取所有网卡发送的总字节数
		public long getTxBytes() throws SigarException{
			String Names[] = sigar.getNetInterfaceList();  ;
			long txBytes = 0L;
			
			for (int i = 0; i < Names.length; i++) {  
			    String name = Names[i];  
			    NetInterfaceConfig ifconfig = sigar.getNetInterfaceConfig(name); 
			    if ((ifconfig.getFlags() & 1L) <= 0L) {    //IFF_UP...skipping getNetInterfaceStat
			        continue;  
			    }  
			    try {  
			        NetInterfaceStat ifstat = sigar.getNetInterfaceStat(name);  
			        txBytes = txBytes + ifstat.getTxBytes();      // 计算所有网卡发送的总字节数 
			    } catch (SigarException e) {  
			    	System.out.println(e.getMessage());  
			    }  
			
			}  
			
			return txBytes;			
	} 
	


		
	public static void main(String[] args) {
		
	}
}
