package me.ep.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import me.ep.dao.UserDAO;
import me.ep.domain.GradeVO;
import me.ep.domain.UserVO;


@WebFilter(filterName="/PremiumUserCheckFilter", urlPatterns= { "/board/vip/*"})
public class PremiumUserCheckFilter implements Filter {
	
	UserDAO udao = UserDAO.getInstance();
	
	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		String toURL = httpRequest.getRequestURI();
		
		// id값이 없으면 돌려보내기
        if(session.getAttribute("id") == null) {
        	request.getRequestDispatcher(toURL).forward(request, response);   
        }
        
        // id 값이 있으면 DB에서 user 꺼내오기
        UserVO user = udao.selectUser((String) session.getAttribute("id"));
        
        // user의 등급이 플래티넘 이상일 때,
        // 해당하는 게시글로 이동(추후 추가)
        if(user.getGrade() >= GradeVO.PLATINUM) {
        	toURL = "/board/list.jsp";  
        }
        
        request.getRequestDispatcher(toURL).forward(request, response);
        
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
