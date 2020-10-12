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

@WebServlet("/UserModifyAction")
public class UserModifyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 싱글톤 dao를 불러온다.
	UserDAO udao = UserDAO.getInstance();
	
	// 매개변수 user가 DB에 저장되어있는지.
	public boolean isValidModifyUser(UserVO user) {
	
		if(udao.selectUser(user.getId()) == null)
			return false;
		
		return true;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET 방식으로 접근하면 
		// attribute 값을 변경해서 전달
		request.setAttribute("modify", "true");
		request.getRequestDispatcher("/views/myPage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//이전 경로를 기억해서 toURL의 default 값을 설정한다.
		String prePath ="/";
		if(request.getAttribute("prePath") != null)
			prePath = (String) request.getAttribute("prePath");
		String toURL = prePath;
		
		// user의 각 정보를 받아온다.
		// 변경 페이지의 id input은 readonly 설정으로 되어있다.
		String id = request.getParameter("info_id");
		String pw = request.getParameter("info_pw");
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
		
		// 변경될  user정보로 객체를 생성해준다.
		UserVO user = new UserVO(id,pw,name,email,phoneNum,date);
		
		// DB에 user가 있는지 확인하고 user가 있으면
		// 해당 정보로 정보를 바꿔준다.
		if(isValidModifyUser(user)) {
			udao.updateUser(user);
			System.out.println("업데이트 완료");
			toURL = "/views/myPage.jsp";
		}
		
		request.getRequestDispatcher(toURL).forward(request, response);
	}

}
