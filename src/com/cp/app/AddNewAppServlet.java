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
		List<Object> listReq = new ArrayList<>();
		try {
			String verisonId = request.getParameter("versionid");
			String bigVersion = verisonId.substring(0, verisonId.indexOf("."));
			String mediumVersion = verisonId.substring(verisonId.indexOf(".")+1, verisonId.lastIndexOf("."));
			String smallVersion = verisonId.substring(verisonId.lastIndexOf(".")+1, verisonId.length());
			
			
			listReq.add(request.getParameter("appname"));
			listReq.add(bigVersion);
			listReq.add(mediumVersion);
			listReq.add(smallVersion);
			listReq.add(request.getParameter("author"));
			listReq.add(request.getParameter("apptype"));
			listReq.add(request.getParameter("content"));
			listReq.add(new GetTime().getDateAndTime());
			listReq.add(GetTime.getPageDate());
			String sql = "insert into apps(title,bigVersion,mediumVersion,smallVersion,submit,type,description,time,showTime) values(?,?,?,?,?,?,?,?,?)";
			InsertOperation.insertOne(sql, listReq);	
    	} catch (Exception e) {
		e.printStackTrace();
	  }
	  request.getRequestDispatcher("addsuccess.jsp").forward(request,response);
		
	}
	}

