package me.ep.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import me.ep.dao.UserDAO;

@WebListener
public class ContextListener implements ServletContextListener {
	
	static String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	static String DB_USER = "student";
	static String DB_PASSWORD = "1234";

	static Connection conn = null;
	static PreparedStatement pstmt = null;
	
	// 리스너는 웹 서버가 시작한 시점과 종료하는 시점에만 호출한다.
	// 따라서 웹 애플리케이션이 시작하고 끝날때까지 공유하고 있는 객체가 있다면
	// 최초에만 생성해주면 된다.
	// 대표적으로 DAO가 있다.
    @Override
    public void contextInitialized(ServletContextEvent event) {
        
    	ServletContext sc = event.getServletContext();
        
    	try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			UserDAO udao = new UserDAO();
			udao.setConnection(conn);
			sc.setAttribute("udao", udao);
			System.out.println("리스너가 정상 작동합니다.");
			
    	} catch(ClassNotFoundException | SQLException e) {
    		e.printStackTrace();
    	}
    	
    	
    	
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    	{

			try {
				pstmt.close();

				conn.close();
				System.out.println("리스너 마무리");
			} catch ( SQLException e ) {}

		}
    }
}