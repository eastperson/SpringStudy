package me.ep.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutAction")
public class UserLogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션에 id attribute가 있으면, 세션 만료
		if(request.getSession().getAttribute("id") != null)
			request.getSession().invalidate();
		
		// 이전 경로로 이동
		String toURL = "/";
		if(request.getParameter("prePath") != null)
			toURL = request.getParameter("prePath");
		
		response.sendRedirect(toURL);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
