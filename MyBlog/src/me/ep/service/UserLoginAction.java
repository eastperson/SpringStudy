package me.ep.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.ep.dao.UserDAO;
import me.ep.domain.UserVO;

@WebServlet("/LoginAction")
public class UserLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	UserDAO udao = UserDAO.getInstance();
	
	boolean isValidUser(String id, String pw) {
		
		UserVO user = udao.selectUser(id);
		
		System.out.println(user);
		
		if(user==null)
			return false;
		if(!user.getPw().equals(pw))
			return false;
		
		return true;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		System.out.println(id);
		System.out.println(pw);
		String prePath ="/";
		if(request.getAttribute("prePath") != null)
			prePath = (String) request.getAttribute("prePath");
		String toURL = "/";
		
		
		if(isValidUser(id,pw)) {
			System.out.println("통과");
			request.setAttribute("loginUser", udao.selectUser(id));
			request.getSession().setAttribute("id", id);
			request.setAttribute("prePath", prePath);
			toURL = prePath;
		}
		
		else {
			System.out.println("실패");
			request.setAttribute("msg", "id 혹은 pw가 일치하지 않습니다.");
			request.setAttribute("prePath", prePath);
		}
		
		RequestDispatcher reqDis = request.getRequestDispatcher(toURL);
		reqDis.forward(request, response);
	}

}
