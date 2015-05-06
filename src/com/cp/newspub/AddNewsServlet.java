package com.cp.newspub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cp.JDBC.InsertOperation;
import com.cp.basefunc.GetTime;
import com.cp.serverInfo.ServerInfo2;
import com.cp.upload.SmallUpImgNoRatio;
import com.cp.upload.UploadFile;
import com.jspsmart.upload.Request;



/**
 * Servlet implementation class AddNews
 */
@WebServlet("/AddNewsServlet")
public class AddNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewsServlet() {
        super();
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		UploadFile uploadFile = new UploadFile(this.getServletConfig());	
		Request req=null;
		String localIP = new ServerInfo2().getIpAddr();
		String port = new ServerInfo2().getPort();
		List<Object> listReq = new ArrayList<>();
		
        try {        		
			uploadFile.upload(request, response, "png|jpg|gif|jpeg|bmp", "image");
			String thumbFileName = SmallUpImgNoRatio.smallUpload(uploadFile.getFName(), uploadFile.getExtName(), uploadFile.getRootPath(), 32, 32);
			UUID uuid = UUID.randomUUID();
			req=uploadFile.getRequest();
			
			//System.out.println(req.getParameter("newstitle"));
			listReq.add(req.getParameter("newstitle"));			
			listReq.add(req.getParameter("newsauthor"));
			//System.out.println(req.getParameter("newstitle"));
			listReq.add(req.getParameter("remark"));
			listReq.add(req.getParameter("content"));
			listReq.add(uploadFile.getRootPath());
			listReq.add(new GetTime().getDateAndTime());
			listReq.add(GetTime.getPageDate());
			listReq.add(String.valueOf(uuid));
			listReq.add("http://"+localIP+":"+port+"/cpServerPro/Upload/image/"+thumbFileName.substring(thumbFileName.lastIndexOf("/")+1, thumbFileName.length()));
			listReq.add("http://"+localIP+":"+port+"/cpServerPro/getnews.jsp?uuid="+uuid);
			listReq.add("/"+thumbFileName.substring(thumbFileName.lastIndexOf("/")+1, thumbFileName.length()));
			String sql = "insert into news(title,author,abstract,content,imageOri,time,showTime,uuid,imageThumbnailUrl,contentUrl,imageThumbnail) values(?,?,?,?,?,?,?,?,?,?,?)";
			InsertOperation.insertOne(sql, listReq);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        response.setCharacterEncoding("UTF-8");	
        request.getRequestDispatcher("addsuccess.jsp").forward(request,response);
       // response.sendRedirect("addsuccess.jsp");
	}
	
}
