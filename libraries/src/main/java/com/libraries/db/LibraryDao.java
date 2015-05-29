package com.libraries.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.libraries.domain.Magazine;
import com.libraries.domain.Rating;

public class LibraryDao {
	
	public static void insertRating(int rate) throws SQLException{
		try(Connection connection = ConnectionDB.getConnection()){
			String sql = "insert into ratings (rating) values(?);";
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, rate);
			stm.addBatch();
			stm.executeBatch();
		}
	}
	
	public static void insertAuthor(String name, String secondName) throws SQLException{
		try(Connection connection = ConnectionDB.getConnection()){
			String sql = "insert into author (name, secondname) values (?, ?);";
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, name);
			stm.setString(2, secondName);
			stm.addBatch();
			stm.executeBatch();
		}
	}

	public static void insertBook(String title, int volume_sheets,
			int releaseYear, String type) throws SQLException {
		try (Connection connection = ConnectionDB.getConnection()) {
			String sql = "insert into books (title, volume_sheets, release_year, type)"
					+ "values (?, ?, ?, ?);";
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, title);
			stm.setInt(2, volume_sheets);
			stm.setInt(3, releaseYear);
			stm.setString(4, type);
			//stm.setInt(5, authorId);
			stm.addBatch();
			stm.executeBatch();
		}
	}

	public static void insertMagazine(int number, int author_id, String title,
			String type) throws SQLException {
		try (Connection connection = ConnectionDB.getConnection()) {
			String sql = "insert into magazines (number, author_id, title, type)"
					+ "values (?, ?, ?, ?);";
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, number);
			stm.setInt(2, author_id);
			stm.setString(3, title);
			stm.setString(4, type);
			stm.addBatch();
			stm.executeBatch();
		}
	}

	public static void selectInfo(String info) throws SQLException {
		try (Connection connection = ConnectionDB.getConnection();
				Statement stm = connection.createStatement();) {
			String sqlName = "Paolo Koelio";
			if (info == sqlName) {
				String sql = "select books.title from books where author_id = 2;";
				stm.execute(sql);
			}
		}
	}

	public static void selectNumberMagazine(int num) throws SQLException {
		try (Connection connection = ConnectionDB.getConnection();
				Statement stm = connection.createStatement();) {
			switch (num) {
				case 1 :
					String sql = "select number from magazines where title = 'AutoBuild';";
					stm.execute(sql);
					break;
				case 2 :
					String sqlNumTwo = "Select number from magazines where type = 'cars';";
					break;
				// continue
				default :
					System.out.println("Nothing to select.");
					break;
			}
		}
	}

	public static void getBookRating(int rating) throws SQLException {
		try (Connection connection = ConnectionDB.getConnection();
				Statement stm = connection.createStatement();) {
			switch (rating) {
				case 1 :
					String sqlOne = "select rating from ratings where books_id = 1";
					stm.execute(sqlOne);
					break;
				case 2 :
					String sqlTwo = "select rating from ratings where books_id = 2";
					stm.execute(sqlTwo);
					break;
				case 3 :
					String sqlThree = "select rating from ratings where books_id = 3";
					stm.execute(sqlThree);
					break;
				case 4 :
					String sqlFour = "select rating from ratings where books_id = 4";
					stm.execute(sqlFour);
					break;
				case 5 :
					String sqlFive = "select rating from ratings where books_id = 5";
					stm.execute(sqlFive);
					break;
				default :
					System.out.println("Nothing to select.");
					break;
			}
		}

	}
	
	public static void main(String[] args) throws SQLException {
		//insertRating(4);
		//insertBook("Lord of the rings", 1000, 2010, "fantastic", 12);
		//insertMagazine(3, 5, "Spisanie 8", "nauchen");
	}

}
