/**
 * 
 */
package com.cp.upload;

import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cp.basefunc.RandomNum;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUploadException;
import com.jspsmart.upload.SmartUpload;

/**
 * 单个文件上传功能
 * @param
 * @return
 */
public class uploadFile {
	
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
    private static final String CONTENT_TYPE = "text/html; charset=utf-8";
    
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }
    final public ServletConfig getServletConfig() {
        return config;  
    }    
    public uploadFile(){
        super();
    }
	
    public String getRootPath() {
		return rootPath;
	}

	public String getFileName() {
		return fileName;
	}

	public String getExtName() {
		return extName;
	}

	public Request getRequest() {
		return request;
	}
	
	
	
	/**
	 * @param rootPath 文件根路径变量
	 * @param fileName 文件名
	 * @param extName  文件扩展名
	 * @param request  请求对象 
	 */
	private String rootPath;
    private String fileName;
    private String extName;
    private Request request;
    
	/**
	 * @param req        Request请求对象  
	 * @param res        Response响应对象
	 * @param upFileType  上传文件类型
	 * @param filePath    上传文件路径 
	 */
	public void upload(HttpServletRequest req, HttpServletResponse res, String upFileType, String filePath) throws Exception{
		res.setContentType("text/html");
    	res.setCharacterEncoding("UTF-8"); 
    	req.setCharacterEncoding("UTF-8");
    	String rootPath;                   //创建根路径保存变量
    	String realPath = req.getSession().getServletContext().getRealPath("/");
    	realPath = realPath.substring(0,realPath.lastIndexOf("\\"));
    	rootPath = realPath+"\\upload\\"+filePath+"\\";  //创建文件的保存目录
    	System.out.println(rootPath);
    	    	
        SmartUpload su = new SmartUpload();
        su.initialize(getServletConfig(), req, res);
    	try {
			su.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
    	
    	com.jspsmart.upload.File myFile = su.getFiles().getFile(0);
    	if (!myFile.isMissing())
    	{       
    	  String myFileName=myFile.getFileName();  //得到文件名  
    	  String fileType=myFile.getFileExt();     //得到文件扩展名
    	  fileType=fileType.toLowerCase();         //将扩展名转换成小写
    	  String randomNum = RandomNum.getRandomNumber(6);  //生成随机数，添加到文件后缀名作标识
    	 if (upFileType.indexOf(fileType)==-1)
  	    {
  	        throw new Exception("wrong file type");
  	    }     
    	 this.rootPath = rootPath;
    	 fileName = randomNum+myFileName;
    	 extName = fileType;
    	 request = su.getRequest();
    	 myFile.saveAs(rootPath+randomNum+myFileName);  //文件保存位置
       }
    	
  }
}
