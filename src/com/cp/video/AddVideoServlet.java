package com.cp.video;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cp.JDBC.InsertOperation;
import com.cp.basefunc.GetTime;
import com.cp.upload.MultiUploadFile;
import com.cp.upload.SmallUpImgNoRatio;
import com.jspsmart.upload.Request;

/**
 * Servlet implementation class AddVideoServlet
 */
@WebServlet("/AddVideoServlet")
public class AddVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		  	String type = request.getParameter("type");
		    MultiUploadFile multiUpload = new MultiUploadFile(this.getServletConfig());
		    Request req = null;
		    List<Object> listReq = new ArrayList<>();
			try {
				multiUpload.multiUploadVideo(request, response,"video");

				req = multiUpload.getRequest();
				for(int i = 1; i <= multiUpload.getFileCount();i++){
					listReq.clear();
					String oripath = multiUpload.getRootPath()+multiUpload.getFileTotalName().get(i-1);
					listReq.add(req.getParameter("filedescp"+i));	
					listReq.add(oripath);
					
					String filename = multiUpload.getFileTotalName().get(i-1).substring(0,multiUpload.getFileTotalName().get(i-1).indexOf("."))+".jpg";
					String imagepath = multiUpload.getRootPath()+filename;
					
					listReq.add("Upload/video/"+filename);
					listReq.add(type);
					listReq.add(new GetTime().getDateAndTime());
					listReq.add(GetTime.getPageDate());
					listReq.add("/Upload/video/"+multiUpload.getFileTotalName().get(i-1));

					String sql = "insert into exhibition(description,oripath,thumbpath,type,time,showTime,Url) values(?,?,?,?,?,?,?)";
					InsertOperation.insertOne(sql, listReq);
					new GenerateImage().getThumbnail(oripath, imagepath, "32*32",request);  //生成显示视频的图片第一帧
					
				}
				 
			} catch (Exception e) {
				e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");	
		request.getRequestDispatcher("addsuccess.jsp").forward(request,response);
	}

}
