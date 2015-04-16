package com.cp.basefunc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
	 // //将父类转成子类	
     HttpServletRequest request = (HttpServletRequest)servletRequest;
     HttpServletResponse response = (HttpServletResponse)servletResponse;
     HttpSession session = request.getSession();
     String login = (String)session.getAttribute("login");
     System.out.println("login:"+login);
     String currentURL = request.getRequestURI();
     String targetURL = currentURL.substring(currentURL.indexOf("/", 1)+1,currentURL.length());
    // System.out.println(currentURL);
     System.out.println(targetURL);
   if(targetURL.equals("accountauth.jsp")||targetURL.equals("interface.jsp")){
	   filterChain.doFilter(request, response);  
   }
   else{
	   if(session==null||login==null){ //最开始服务器加载时候
	    	 System.out.println("1");
	    	   request.getRequestDispatcher("login.jsp").forward(request, response);
	     }else{
	    	 if(login.equals("true")){
	    		 System.out.println("2");
	    		// request.getRequestDispatcher("index.jsp").forward(request, response);
	    		filterChain.doFilter(request, response); //如果登录过，就不阻拦
	         }
	         else{
	        	 System.out.println("3");
	        	 request.getRequestDispatcher("login.jsp").forward(request, response);
	         } 	 
	     }   
   }
     
       
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
