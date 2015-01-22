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
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		uploadFile upFile = new uploadFile();
		Request req=null;
        try {
        	upFile.init(this.getServletConfig());
			upFile.upload(request, response, "png", "image");
			req=upFile.getRequest();
			Enumeration<String> names=req.getParameterNames();
			List<String> lName=new ArrayList<String>();
			while(names.hasMoreElements()){
				lName.add(names.nextElement())	;							
			}
			for (String item : lName) {
			//	System.out.println(item);
			//	System.out.println(req.getParameter(item));
			}
		//	System.out.println(req.getParameter("newstitle"));
		} catch (Exception e) {
			e.printStackTrace();
		}
     	*/
		MultiUploadFile multiUpFile = new MultiUploadFile();
		Request req = null;
		try {
			multiUpFile.init(this.getServletConfig());
			multiUpFile.multiUpload(request, response, "png", "image");
			List<String> list = new ArrayList<String>();
			list = multiUpFile.getFileName();
			System.out.println(list.get(0));		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
