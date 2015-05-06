/**
 * 
 */
package com.cp.video;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DELL
 *
 */
public class GenerateImage {
	public boolean getThumbnail(String videoPath,String imagePath,String size,HttpServletRequest request){
		boolean result=false;
		String  toolPath = request.getServletContext().getRealPath("/ffmpeg/bin/ffmpeg.exe");
		//System.out.println(toolPath);
		List<String> command = new ArrayList<String>();
		command.add(toolPath);
		command.add("-i");
		command.add(videoPath);
		command.add("-y");
		command.add("-f");
		command.add("image2");
		command.add("-ss");
		command.add("1");
		command.add("-t");
		command.add("0.001");
		command.add("-s");
		command.add(size);
		command.add(imagePath);
		
		try {
			@SuppressWarnings("unused")
			ProcessBuilder builder= new ProcessBuilder();
			builder.command(command);
			builder.redirectErrorStream(true);
			builder.start();
			result= true;
			//			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			
		}
		return result;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new GenerateImage().getThumbnail("C:\\Users\\DELL\\Desktop\\正大测试\\cptest.mp4", "D:\\javaProject\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\cpServerPro/Upload/video/testjpg3.jpg", "64*64");
	}

}
