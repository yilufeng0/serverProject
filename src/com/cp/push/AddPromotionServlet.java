package com.cp.push;

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
		request.setCharacterEncoding("UTF-8");
		List<Object> listReq = new ArrayList<>();
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
		
		try {
			//推送内容插入数据库
			listReq.add(request.getParameter("ticker"));
			listReq.add(request.getParameter("title"));
			listReq.add(request.getParameter("notidesc"));
			listReq.add(request.getParameter("content"));
			listReq.add(new GetTime().getDateAndTime());
			listReq.add(String.valueOf(uuid));
			
			String targetUrl = "http://103.244.82.219:8080/cpServerPro/getpush.jsp?uuid="+String.valueOf(uuid);
			System.out.println(targetUrl);
			
			String sql = "insert into push(tips,title,abstract,content,time,uuid) values(?,?,?,?,?,?)";
			InsertOperation.insertOne(sql, listReq);	
			//Android推送
			Push pushAndroid = new Push(new GetPushParameter().getAPP_KEY("android"), new GetPushParameter().getAPP_MASTER_SECRET("android"));
			pushAndroid.sendAndroidBroadcast(request.getParameter("ticker"),request.getParameter("title"),request.getParameter("content"),targetUrl);
			//IOS推送  
			Push pushIOS = new Push(new GetPushParameter().getAPP_KEY("ios"), new GetPushParameter().getAPP_MASTER_SECRET("ios"));
			pushIOS.sendIOSBroadcast(request.getParameter("title"),targetUrl);      
			
    	} catch (Exception e) {
		e.printStackTrace();
	  }
	  response.setCharacterEncoding("UTF-8");
	  request.getRequestDispatcher("addsuccess.jsp").forward(request,response);
		
	}

}
