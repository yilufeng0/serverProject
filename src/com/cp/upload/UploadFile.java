/**
 * 
 */
package com.cp.upload;

import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cp.basefunc.RandomNum;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * 单个文件上传功能
 */
public class UploadFile {
	
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
    private static final String CONTENT_TYPE = "text/html; charset=utf-8";
    
    /**
	 * @param config
	 */
    public UploadFile(){
        super();
    }
    
    /**
	 * @param config
	 */
	public UploadFile(ServletConfig config) {
		super();
		this.config = config;
	}
    
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    /**
	 * @param rootPath 文件根路径变量
	 * @param fileName 文件名
	 * @param fileTotalName 文件全名
	 * @param extName  文件扩展名
	 * @param request  请求对象 
	 */
    
	private String rootPath;
    private String fileName;
    private String fName;
    private String extName;
    private Request request;

	
    public String getRootPath() {
		return rootPath;
	}

	public String getFileName() {
		return fileName;
	}
	
	public String getFName() {
		return fName;
	}

	public String getExtName() {
		return extName;
	}
	
	public Request getRequest() {
		return request;
	}
	
	
    
	/**
	 * @param req        Request请求对象  
	 * @param res        Response响应对象
	 * @param upFileType  上传文件类型
	 * @param filePath    上传文件路径 
	 */
	public void upload(HttpServletRequest req, HttpServletResponse res, String upFileType, String filePath) throws Exception{
		if (null==this.config) {
			throw new Exception("无法获取配置文件，使用前需要初始化");
		}
		res.setContentType("text/html");
    	res.setCharacterEncoding("UTF-8"); 
    	req.setCharacterEncoding("UTF-8");
    	
    	String rootPath,rPath;                   //创建根路径保存变量
//     	String realPath = req.getSession().getServletContext().getRealPath("/");
     	String realPath = req.getServletContext().getRealPath("/");
//     	realPath = realPath.substring(0, realPath.indexOf(":")+1);
//     	rootPath = realPath+"/Upload/"+filePath+"/";
     	rootPath = realPath + "/Upload/"+filePath+"/";
//     	rPath = "/"+filePath+"/";
     	
     	File dirName = new File(rootPath);
     	if(!dirName.isDirectory())  //如果目录不存在
     	{
     		dirName.mkdirs(); //创建多级目录
     	}
   ///////////////////////////////////////////////////////////
     	
//     	File diName = new File(rPath);
//     	if(!diName.isDirectory())  //如果目录不存在
//     	{
//     		diName.mkdirs(); //创建多级目录
//     	}
//     	
        SmartUpload su = new SmartUpload();
        su.initialize(this.config, req, res);
    	try {
			su.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
    	
    	com.jspsmart.upload.File myFile = su.getFiles().getFile(0);
    	if (!myFile.isMissing())
    	{       
    	  String totalFileName=myFile.getFileName();  //得到文件名+扩展名   
    	  String myFileName = totalFileName.substring(0, totalFileName.lastIndexOf(".")); //得到文件名
    	  String fileType=myFile.getFileExt();     //得到文件扩展名
    	  fileType=fileType.toLowerCase();         //将扩展名转换成小写
    	  String randomNum = RandomNum.getRandomNumber(6);  //生成随机数，添加到文件后缀名作标识
    	  
    	  this.rootPath = rootPath;
     	  fileName = myFileName+randomNum+"."+fileType;
     	  fName = myFileName+randomNum;
     	  extName = fileType;
     	  request = su.getRequest();

     	  
    	 if (upFileType.indexOf(fileType)==-1)
  	    {
  	       //throw new Exception("上传文件错误");
    	     myFileName = "imagebackup";     //上传文件类型错误时，选择默认图片上传
    	     fileType = "png";
    	     this.rootPath = rootPath;
        	 fileName = myFileName+"."+fileType;
        	 fName = myFileName;
        	 extName = fileType;
        	 request = su.getRequest();	     
    		 return;
  	    }  		
        //	 myFile.saveAs(rPath+randomNum+myFileName,1);  //VIRTUAL方式保存文件
        	 myFile.saveAs(rootPath+fileName,2);  //PHYSICAL方式保存文件
       }
    	
  }
	
}
