package com.cp.newspub;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hyperic.sigar.SigarException;

import com.cp.serverInfo.ServerInfo;
import com.cp.upload.*;
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
        // TODO Auto-generated constructor stub
    }
    
    
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		this.doPost(req, resp);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//		UploadFile uploadFile = new UploadFile(this.getServletConfig());
//		Request req=null;
//		List<Object> listReq = new ArrayList<>();
//        try {        	
//			uploadFile.upload(request, response, "png|jpg|gif|jpeg|bmp", "image");
//			req=uploadFile.getRequest();
//			listReq.add(req.getParameter("newstitle"));			
//			listReq.add(req.getParameter("newsauthor"));
//			listReq.add(req.getParameter("remark"));
//			listReq.add(req.getParameter("content"));
//			listReq.add(uploadFile.getFileName());
//			listReq.add(uploadFile.getExtName());
//			listReq.add(uploadFile.getRootPath());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
        ServerInfo serverInfo = new ServerInfo();
        try {
			System.out.println(String.valueOf(serverInfo.getMemUsageRatio()));
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		try {
			new AddNewsServlet().doPost(null, null);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
