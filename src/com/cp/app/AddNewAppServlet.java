package com.cp.app;

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
import com.cp.serverInfo.ServerInfo;
import com.cp.upload.UploadFile;
import com.jspsmart.upload.Request;

/**
 * Servlet implementation class AddNewAppServlet
 */
@WebServlet("/AddNewAppServlet")
public class AddNewAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewAppServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UploadFile uploadFile = new UploadFile(this.getServletConfig());
		Request req = null;
		List<Object> listReq = new ArrayList<>();
		String localIP = new ServerInfo().getIpAddr();
		try {
			uploadFile.upload(request, response, "apk|ipa|xap", "apps");
			req = uploadFile.getRequest();
			String verisonId = req.getParameter("versionid");
			String bigVersion = verisonId.substring(0, verisonId.indexOf("."));
			String mediumVersion = verisonId.substring(verisonId.indexOf(".")+1, verisonId.lastIndexOf("."));
			String smallVersion = verisonId.substring(verisonId.lastIndexOf(".")+1, verisonId.length());
				
			listReq.add(req.getParameter("appname"));
			listReq.add(bigVersion);
			listReq.add(mediumVersion);
			listReq.add(smallVersion);
			listReq.add(req.getParameter("author"));
			listReq.add(req.getParameter("apptype"));
			listReq.add(req.getParameter("content"));
			listReq.add(new GetTime().getDateAndTime());
			listReq.add(GetTime.getPageDate());
			listReq.add("http://"+localIP+":8080/cpServerPro/app/"+uploadFile.getFileName());
			String sql = "insert into apps(title,bigVersion,mediumVersion,smallVersion,submit,type,description,time,showTime,Url) values(?,?,?,?,?,?,?,?,?,?)";
			InsertOperation.insertOne(sql, listReq);	
    	} catch (Exception e) {
		e.printStackTrace();
	  }
	  response.setCharacterEncoding("UTF-8");
	  request.getRequestDispatcher("addsuccess.jsp").forward(request,response);
		
	}
	}

