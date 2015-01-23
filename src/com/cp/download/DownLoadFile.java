/**
 * 
 */
package com.cp.download;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * 单文件下载功能
 */
public class DownLoadFile {
	
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
    private static final String CONTENT_TYPE = "text/html; charset=utf-8";
    
    /**
	 * @param config
	 */
    public DownLoadFile(){
        super();
    }
    
    /**
	 * @param config
	 */
	public DownLoadFile(ServletConfig config) {
		super();
		this.config = config;
	}
    
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    
    /**
     * @param req       Request请求对象  
     * @param res       Response响应对象
     * @param fileName    下载文件名
     * @param filePath    下载源文件路径 
     */
    public void download(HttpServletRequest req, HttpServletResponse res, String fileName, String filePath) throws Exception {
    	if (null==this.config) {
			throw new Exception("无法获取配置文件，使用前需要初始化");
		}
		res.setContentType("text/html");
    	res.setCharacterEncoding("UTF-8"); 
    	req.setCharacterEncoding("UTF-8");
    	
    	String rootPath;                   //创建根路径保存变量
     	String realPath = req.getSession().getServletContext().getRealPath("/");
     	realPath = realPath.substring(0, realPath.indexOf(":")+1);
     	rootPath = realPath+"/Upload/"+filePath+"/"+fileName;
     	
     	SmartUpload su = new SmartUpload();
        su.initialize(this.config, req, res);
        su.downloadFile(rootPath);
        
    }
    
    
    
    
    
    
    
    
}
