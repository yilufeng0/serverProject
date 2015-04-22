/**
 * 
 */
package com.cp.video;

import javax.servlet.http.HttpServletRequest;

/**
 * @author DELL
 *
 */
public class GenerateImage {
	public boolean getThumbnail(String videoPath,String imagePath,String size,HttpServletRequest request){
		boolean result=false;
		String rootpath = request.getServletContext().getRealPath("/");
		//String command = "cmd /c  start D:\\ffmpeg\\ffmpeg.bat "+ videoPath+" "+size+" "+imagePath;
		String command = "cmd /c "+rootpath+"\\ffmpeg\\bin\\ffmpeg.exe -i "+videoPath+" -ss 1 -vframes 1 -r 1 -ac 1 -ab 2 -s "+size+" -f image2 "+imagePath+" -y";
		try {
			Runtime.getRuntime().exec(command);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
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
