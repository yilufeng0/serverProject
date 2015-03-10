/**
 * 
 */
package com.cp.upload;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cp.basefunc.RandomNum;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;


/**
 * 多文件上传功能
 */
public class MultiUploadFile {
	
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	
	/**
	 * @param rootPath   文件根路径变量
	 * @param fileTotalName   文件全名（包含扩展名及随机数）
	 * @param 
	 * @param extName    文件扩展名
	 * @param request    请求对象 
	 * @param fileCount  上传文件数
	 */
	private String rootPath;
    private List<String> fileTotalName = new ArrayList<String>();
    private List<String> fileName = new ArrayList<String>();
    private List<String> extName = new ArrayList<String>();
    private Request request;
    private int fileCount;
    
    public String getRootPath() {
		return rootPath;
	}
    
	public List<String> getFileTotalName() {
		return fileTotalName;
	}
	
	public List<String> getExtName() {
		return extName;
	}
	
	public Request getRequest() {
		return request;
	}
	
	public int getFileCount(){
		return fileCount;
	}
	
	public List<String> getFileName() {
		return fileName;
	}
	
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
    
	public MultiUploadFile(ServletConfig config) {
		super();
		this.config = config;
	}
    
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }  
    
    public MultiUploadFile(){
        super();
    }
	
    
	public void multiUpload(HttpServletRequest req, HttpServletResponse res, String upFileType, String filePath) throws Exception{
		if (null==this.config) {
			throw new Exception("无法获取配置文件，使用前需要初始化");
		}
		res.setContentType("text/html");
    	res.setCharacterEncoding("UTF-8"); 
    	req.setCharacterEncoding("UTF-8");
    	
    	String rootPath;                   //创建根路径保存变量
     	String realPath = req.getSession().getServletContext().getRealPath("/");
     	realPath = realPath.substring(0, realPath.indexOf(":")+1);
     	rootPath = realPath+"/Upload/"+filePath+"/";
     	File dirName = new File(rootPath);
     	if(!dirName.isDirectory())  //如果目录不存在
     	{
     		dirName.mkdirs(); //创建多级目录
     	}
    	
        SmartUpload su = new SmartUpload();
        su.initialize(this.config, req, res);

    	try {
			su.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
    	
    	fileCount = su.getFiles().getCount();
    	
    	//循环取得上传所有文件
     for(int i=0;i<su.getFiles().getCount();i++){
        com.jspsmart.upload.File myFile = su.getFiles().getFile(i);
       if(!myFile.isMissing())
       {       
     	  String totalFileName = myFile.getFileName();    //得到文件名+扩展名  
     	  String myFileName = totalFileName.substring(0, totalFileName.lastIndexOf(".")); //得到文件名
     	  String randomNum = RandomNum.getRandomNumber(6);  //生成随机数，添加到文件后缀名作标识
    
     	  String fileType=myFile.getFileExt();     //得到文件扩展名
     	  fileType=fileType.toLowerCase();         //将扩展名转换成小写
     	  
     	  extName.add(fileType);
     	  fileName.add(myFileName+randomNum);
     	  fileTotalName.add(myFileName+randomNum+"."+fileType);
     	  
     	 if (upFileType.indexOf(fileType)==-1)
    	 {
      	  throw new Exception("wrong file type");
    	 } 
     	 
     	 this.rootPath = rootPath;
    	 request = su.getRequest();
     //	 myFile.saveAs(rootPath+randomNum+myFileName,1);  //VIRTUAL方式保存文件
    	 myFile.saveAs(rootPath+myFileName+randomNum+"."+fileType,2);  //PHYSICAL方式保存文件
       } 
     }
	}
	
	
	public void multiUploadVideo(HttpServletRequest req, HttpServletResponse res,String filePath) throws Exception{
		if (null==this.config) {
			throw new Exception("无法获取配置文件，使用前需要初始化");
		}
		res.setContentType("text/html");
    	res.setCharacterEncoding("UTF-8"); 
    	req.setCharacterEncoding("UTF-8");
    	
    	String rootPath;                   //创建根路径保存变量
     	String realPath = req.getSession().getServletContext().getRealPath("/");
     	realPath = realPath.substring(0, realPath.indexOf(":")+1);
     	rootPath = realPath+"/Upload/"+filePath+"/";
     	File dirName = new File(rootPath);
     	if(!dirName.isDirectory())  //如果目录不存在
     	{
     		dirName.mkdirs(); //创建多级目录
     	}
    	
        SmartUpload su = new SmartUpload();
        su.initialize(this.config, req, res);

    	try {
			su.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
    	
    	fileCount = su.getFiles().getCount();
    	
    	//循环取得上传所有文件
     for(int i=0;i<su.getFiles().getCount();i++){
        com.jspsmart.upload.File myFile = su.getFiles().getFile(i);
       if(!myFile.isMissing())
       {       
     	  String totalFileName = myFile.getFileName();    //得到文件名+扩展名  
     	  String myFileName = totalFileName.substring(0, totalFileName.lastIndexOf(".")); //得到文件名
     	  String randomNum = RandomNum.getRandomNumber(6);  //生成随机数，添加到文件后缀名作标识
    
     	  String fileType=myFile.getFileExt();     //得到文件扩展名
     	  fileType=fileType.toLowerCase();         //将扩展名转换成小写
     	  
     	  extName.add(fileType);
     	  fileName.add(myFileName+randomNum);
     	  fileTotalName.add(myFileName+randomNum+"."+fileType);
     	  
     	 this.rootPath = rootPath;
    	 request = su.getRequest();
     //	 myFile.saveAs(rootPath+randomNum+myFileName,1);  //VIRTUAL方式保存文件
    	 myFile.saveAs(rootPath+myFileName+randomNum+"."+fileType,2);  //PHYSICAL方式保存文件
       } 
     }
	}

}
