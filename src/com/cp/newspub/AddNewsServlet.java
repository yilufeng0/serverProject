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
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        uploadFileServlet a = new uploadFileServlet();
		uploadFile a= new uploadFile();
		Request req=null;
        try {
        	a.init(this.getServletConfig());
			a.upload(request, response, "png", "image");
			req=a.getRequest();
			Enumeration<String> names=req.getParameterNames();
			List<String> lName=new ArrayList<String>();
			while(names.hasMoreElements()){
				lName.add(names.nextElement())	;							
			}
			for (String item : lName) {
				System.out.println(item);
				System.out.println(req.getParameter(item));
			}
			System.out.println(req.getParameter("newstitle"));
//        	a.doPost(request, response);
		//	System.out.println("test");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	
	}

}
