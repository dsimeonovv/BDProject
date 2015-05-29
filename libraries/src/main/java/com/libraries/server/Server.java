package com.libraries.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;


public class Server {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/libraries";

	static final String user = "root";
	static final String password = "940606";

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		
		try {
			ServerSocket ss = new ServerSocket(1233);
			while (true) {
				Socket s = ss.accept();
				ClientThread ct = new ClientThread(s);
				ct.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connect to selected database..");
			conn = DriverManager.getConnection(DB_URL, user, password);
			System.out.println("Connected to database successfully.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
