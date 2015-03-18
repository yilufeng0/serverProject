package com.cp.account;

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
 * Servlet implementation class AddNewAccountServlet
 */
@WebServlet("/AddNewAccountServlet")
public class AddNewAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewAccountServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Object> listReq = new ArrayList<>();
		try {
			request.setCharacterEncoding("UTF-8");
			listReq.add(request.getParameter("account"));
			listReq.add(request.getParameter("acctype"));
			listReq.add(Integer.toHexString(request.getParameter("passwd").hashCode()));
			listReq.add(new GetTime().getDateAndTime());  
			listReq.add(GetTime.getPageDate());
			String sql = "insert into account(userName,type,passwd,time,showTime) values(?,?,?,?,?)";
			InsertOperation.insertOne(sql, listReq);	
    	} catch (Exception e) {
		e.printStackTrace();
	  }
	  request.getRequestDispatcher("addsuccess.jsp").forward(request,response);
		
	}

}
