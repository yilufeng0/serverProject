package com.cp.upload;

import java.util.ArrayList;
import java.util.List;

import net.coobird.thumbnailator.Thumbnails;


/**
 * 单/多个图片缩略图不按比例转换 
 */
public class SmallUpImgNoRatio {
	    

    public SmallUpImgNoRatio(){
        super();
    }
    
    /**
	* @param fName      图片文件名数组
    * @param fileType   图片文件类型
	* @param filePath   图片文件路径
	* @param width      图片宽度像素值
	* @param height     图片高度像素值
	* @return  返回图片文件名
	*/
	public static ArrayList<String> smallUpload(List<String> fName, List<String> fileType, String filePath, int width, int height) throws Exception{
	   ArrayList<String> fileName = new ArrayList<String>(); 	
       for(int i = 0;i < fName.size();i++){ 
    	 Thumbnails.of(filePath+fName.get(i)+"."+fileType.get(i)).size(width, height).keepAspectRatio(false).toFile(filePath+fName.get(i)+"_"+width+"x"+height+"."+fileType.get(i));
         fileName.add(filePath+fName.get(i)+"_"+width+"x"+height+"."+fileType.get(i));
       }	
       return fileName;
     }
	   
  }
	
