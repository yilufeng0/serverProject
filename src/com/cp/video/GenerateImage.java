/**
 * 
 */
package com.cp.video;

/**
 * @author DELL
 *
 */
public class GenerateImage {
	public boolean getThumbnail(String videoPath,String imagePath,String size){
		boolean result=false;
		String command = "cmd /c  start D:\\ffmpeg\\ffmpeg.bat "+ videoPath+" "+size+" "+imagePath;
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
