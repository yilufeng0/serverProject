/**
 * 
 */
package com.cp.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * 实现文件下载功能(最终版本)
 *
 */
public class DownLoadFileStream {
	
	/**
	 * @param res         请求对象
	 * @param filePath    待下载文件的所在路径
	 * @throws IOException
	 */
	public void downLoad(HttpServletResponse res, String filePath){
		File f = new File(filePath);
		try {
			if(f.exists()){
				FileInputStream  fis = new FileInputStream(f);  
		        String fileName = URLEncoder.encode(f.getName(),"utf-8");  //解决中文文件名下载后乱码的问题  
		       
		        ServletOutputStream  out = res.getOutputStream(); 
		       // PrintWriter out = res.getWriter();
		        res.setCharacterEncoding("utf-8"); 
		        res.setContentType("*/*");
		        res.setHeader("Content-Disposition","attachment; filename="+fileName+"");  
		        byte[] b = new byte[1024];
	          while(fis.read(b)>0){      //如果没有读到文件末尾
	          out.write(b);	           //向流中写数据     
	          }
//		        int i;
//		    	while ((i = fis.read())>0) {
//					out.write(i);
//				}
		        out.flush();  
		        out.close();  
		        fis.close();
		    }
			else
				System.out.println("wrong");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


	}
	
}
	