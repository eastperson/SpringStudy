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
	
	// 싱글톤 dao를 불러온다.
	UserDAO udao = UserDAO.getInstance();
	
	// 저장하기 전에 DB안에 user가 있는지 확인한다.
	// user id가 같은 기존 고객이 있으면 false
	boolean isValidRegisterUser(UserVO user) {
		
		if(udao.selectUser(user.getId()) != null)
			return false;
		
		return true;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//이전 경로를 기억해서 toURL의 default 값을 설정한다.
		String prePath ="/";
		if(request.getAttribute("prePath") != null)
			prePath = (String) request.getAttribute("prePath");
		String toURL = prePath;
		
		// user의 각 정보를 받아온다.
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
		
		
		// 등록 가능한 user인지 확인 완료하면
		// 세션에 아이디를 저장한다.(로그인 상태 유지)
		if(isValidRegisterUser(user)) {
			udao.insertUser(user);
			request.getSession().setAttribute("id", user.getId());
		} 
		
		// msg와 이동 경로를 바꿔준다.
		else {
			request.setAttribute("msg", "이미 존재하는 ID가 있습니다.");
			toURL = "/views/registerForm.jsp";
		}
		request.getRequestDispatcher(toURL).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
