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
		String toURL;
		
        if(session.getAttribute("id") == null) {
        	toURL = "/loginForm.jsp";   
        	RequestDispatcher reqDis = request.getRequestDispatcher(toURL);
        	reqDis.forward(request, response); 
        }
        
        UserVO user = udao.selectUser((String) session.getAttribute("id"));
        
        if(user.getGrade() < GradeVO.PLATINUM) {
        	toURL = "/loginForm.jsp";
        	RequestDispatcher reqDis = request.getRequestDispatcher(toURL);
        	reqDis.forward(request, response); 
        }
        	
        
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
