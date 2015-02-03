package com.cp.push;

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
import com.cp.upload.UploadFile;
import com.jspsmart.upload.Request;

/**
 * Servlet implementation class AddPromotionServlet
 */
@WebServlet("/AddPromotionServlet")
public class AddPromotionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPromotionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		List<Object> listReq = new ArrayList<>();
		try {
			listReq.add(request.getParameter("ticker"));
			listReq.add(request.getParameter("title"));
			listReq.add(request.getParameter("notidesc"));
			listReq.add(request.getParameter("content"));
			listReq.add(new GetTime().getDateAndTime());
			String sql = "insert into push(tips,title,abstract,content,time) values(?,?,?,?,?)";
			InsertOperation.insertOne(sql, listReq);	
    	} catch (Exception e) {
		e.printStackTrace();
	  }
	  request.getRequestDispatcher("addsuccess.jsp").forward(request,response);
		
	}

}
