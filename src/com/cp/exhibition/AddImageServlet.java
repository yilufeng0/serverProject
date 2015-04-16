package com.cp.exhibition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cp.JDBC.InsertOperation;
import com.cp.basefunc.GetTime;
import com.cp.serverInfo.ServerInfo;
import com.cp.upload.MultiUploadFile;
import com.cp.upload.SmallUpImgNoRatio;
import com.jspsmart.upload.Request;

/**
 * Servlet implementation class AddImageServlet
 */
@WebServlet("/AddImageServlet")
public class AddImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddImageServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    request.setCharacterEncoding("UTF-8");
		  	String type = request.getParameter("type");
		  	String localIP = new ServerInfo().getIpAddr();
		    MultiUploadFile multiUpload = new MultiUploadFile(this.getServletConfig());
		    Request req = null;
		    List<Object> listReq = new ArrayList<>();
			try {
				multiUpload.multiUpload(request, response, "png|jpg|gif|jpeg|bmp", "image");
				
				ArrayList<String> thumbFileName = SmallUpImgNoRatio.smallUpload(multiUpload.getFileName(), multiUpload.getExtName(), multiUpload.getRootPath(), 32, 32);
				
				req = multiUpload.getRequest();
				for(int i = 1; i <= multiUpload.getFileCount();i++){
					listReq.clear();
					listReq.add(req.getParameter("filedescp"+i));	
					listReq.add(multiUpload.getRootPath()+multiUpload.getFileTotalName().get(i-1));
					//listReq.add(multiUpload.getRootPath()+thumbFileName.get(i-1).substring(thumbFileName.get(i-1).lastIndexOf("/")+1, thumbFileName.get(i-1).length()));
					//listReq.add("http://"+localIP+":8080/cpServerPro/Upload/image/"+thumbFileName.get(i-1).substring(thumbFileName.get(i-1).lastIndexOf("/")+1, thumbFileName.get(i-1).length()));
					listReq.add("Upload/image/"+thumbFileName.get(i-1).substring(thumbFileName.get(i-1).lastIndexOf("/")+1, thumbFileName.get(i-1).length()));
					listReq.add(type);
					listReq.add(new GetTime().getDateAndTime());
					listReq.add(GetTime.getPageDate());
					listReq.add("/Upload/image/"+multiUpload.getFileTotalName().get(i-1));

					String sql = "insert into exhibition(description,oripath,thumbpath,type,time,showTime,Url) values(?,?,?,?,?,?,?)";
					InsertOperation.insertOne(sql, listReq);
				}
				 
			} catch (Exception e) {
				e.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");	
	}

}
