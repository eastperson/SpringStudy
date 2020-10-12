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
	
	// 1. 매개변수 id의 user가 DB에 저장되어있는지 확인
	// 2. 입력한 비밀번호가 일치하는지 확인
	// 위의 두 조건이 맞으면 true 반환
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
		
		// input 파라미터를 받아온다.
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		//이전 경로를 기억해서 toURL의 default 값을 설정한다.
		String prePath ="/";
		if(request.getAttribute("prePath") != null)
			prePath = (String) request.getAttribute("prePath");
		String toURL = prePath;
		
		// 로그인 성공
		// 세션에 회원의 id 저장
		if(isValidUser(id,pw)) {
			System.out.println(id + "로그인 성공!");
			request.setAttribute("loginUser", udao.selectUser(id));
			request.getSession().setAttribute("id", id);
		}
		// 로그인 실패
		// 실패 msg 전달
		// prePath는 그대로 전달
		else {
			System.out.println("실패");
			request.setAttribute("msg", "id 혹은 pw가 일치하지 않습니다.");
			request.setAttribute("prePath", prePath);
		}
		
		request.getRequestDispatcher(toURL).forward(request, response);
	}

}
