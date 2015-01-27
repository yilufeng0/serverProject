package com.cp.newspub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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


		UploadFile uploadFile = new UploadFile(this.getServletConfig());	
		Request req=null;
		List<Object> listReq = new ArrayList<>();
        try {        	
			uploadFile.upload(request, response, "png|jpg|gif|jpeg|bmp", "image");
			req=uploadFile.getRequest();
			listReq.add(req.getParameter("newstitle"));			
			listReq.add(req.getParameter("newsauthor"));
			listReq.add(req.getParameter("remark"));
			listReq.add(req.getParameter("content"));
			listReq.add(uploadFile.getFileName());
			listReq.add(uploadFile.getExtName());
			listReq.add(uploadFile.getRootPath());
				
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}
	
}
