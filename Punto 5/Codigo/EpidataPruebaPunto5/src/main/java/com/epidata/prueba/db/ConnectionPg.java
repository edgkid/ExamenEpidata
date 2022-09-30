package com.epidata.prueba.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPg {
	
	Connection conn = null;
	
	String user = "postgres";
	String password = "admin";
	String bd = "PruebaEpidataPunto5";
	String ip = "127.0.0.1";
	String port = "5432";
	String jdbc = "jdbc:postgresql://" + ip + ":" + port + "/" + bd;
	
	public Connection dbConnection () {
		
		try {
			
			Class.forName("org.postgresql.Driver");
			this.conn = DriverManager.getConnection(jdbc, user, password);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return this.conn;
	}

}
