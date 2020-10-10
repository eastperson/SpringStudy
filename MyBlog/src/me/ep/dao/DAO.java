package me.ep.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DAO {
	static Connection conn;

	String tableName = "";

	DAO() {
		this(null, "");
	}

	DAO(String tableName) {
		this(null, tableName );
	}

	DAO(Connection conn, String tableName) {
		this.tableName = tableName;
	}



	public void rollback(){

		if(conn!=null) {

			try {

				conn.rollback();

			} catch(SQLException e){
			}
		}
	}
	void close(AutoCloseable... acs) throws Exception {
	}
}