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

@WebServlet("/UserWithdrawAction")
public class UserWithdrawAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserDAO udao = UserDAO.getInstance();
	
	// 삭제 가능한 user인지 확인한다.(기존 사용자인지)
	boolean isValidWithdrawUser(UserVO user) {
		
		if(udao.selectUser(user.getId()) == null)
			return false;
		
		return true;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//이전 경로를 기억해서 toURL의 default 값을 설정한다.
		String prePath ="/";
		if(request.getAttribute("prePath") != null)
			prePath = (String) request.getAttribute("prePath");
		String toURL = prePath;
		
		UserVO user = udao.selectUser((String)request.getSession().getAttribute("id"));
		
		// 탈퇴 가능한 계정이면
		// 해당 user를 삭제한다.
		// 세션값도 만료시킨다.
		if(isValidWithdrawUser(user)) {
			udao.deleteUser(user.getId());
			request.getSession().invalidate();
		} 
		
		else {
			request.setAttribute("msg", "해당 ID의 유저가 없습니다.");
			toURL = "/views/registerForm.jsp";
		}
		request.getRequestDispatcher(toURL).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
