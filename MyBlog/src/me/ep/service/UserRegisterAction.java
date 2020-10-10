package me.ep.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.ep.dao.UserDAO;
import me.ep.domain.UserVO;

@WebServlet("/RegisterAction")
public class UserRegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDAO udao = UserDAO.getInstance();
	
	boolean isValidRegisterUser(UserVO user) {
		
		if(udao.selectUser(user.getId()) != null)
			return false;
		
		return true;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prePath = "/";
		String toURL = prePath;
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneNum = request.getParameter("phoneNum").replaceAll("-", "");
		String dateOfBirth = request.getParameter("dateOfBirth");
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
		} catch (ParseException e) {
			e.printStackTrace();
			return;
		}  

		UserVO user = new UserVO(id,pw,name,email,phoneNum,date);
		
		if(isValidRegisterUser(user)) {
			udao.insertUser(user);
			request.getSession().setAttribute("id", user.getId());
		} 
		
		else {
			request.setAttribute("msg", "이미 존재하는 ID가 있습니다.");
			toURL = "/views/registerForm.jsp";
		}
		RequestDispatcher reqDis = request.getRequestDispatcher(toURL);
		reqDis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
