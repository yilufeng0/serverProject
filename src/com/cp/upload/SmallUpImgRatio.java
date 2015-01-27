/**
 * 
 */
package com.cp.upload;

import java.util.ArrayList;

import net.coobird.thumbnailator.Thumbnails;


/**
 * 单/多个图片缩略图按比例转换 
 */
public class SmallUpImgRatio {
	 
    public SmallUpImgRatio(){
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
	public ArrayList<String> smallUpload(String[] fName, String fileType, String filePath, int width, int height) throws Exception{
	   ArrayList<String> fileName = new ArrayList<String>(); 	
       for(int i = 0;i < fName.length;i++){ 
    	 Thumbnails.of(filePath+fName[i]+"."+fileType).size(width, height).toFile(filePath+fName[i]+"_R"+width+"x"+height+"."+fileType);
         fileName.add(filePath+fName[i]+"_R"+width+"x"+height+"."+fileType);
       }	
       return fileName;
     }
	
  }
	

