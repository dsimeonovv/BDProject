package com.libraries.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import com.libraries.domain.Author;
import com.libraries.domain.Book;
import com.libraries.domain.MagazineContent;
import com.libraries.domain.Rating;

public class TestDao {

	public static List<Book> selectBooksByType(String type) throws SQLException {
		try (Connection connection = ConnectionDB.getConnection();) {
			String sql = "SELECT * FROM books WHERE type = ?;";
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, type);
			ResultSet rs = stm.executeQuery();
			List<Book> books = new ArrayList<>();
			while (rs.next()) {
				String title = rs.getString("title");
				int volumeSheets = rs.getInt("volume_sheets");
				int release_year = rs.getInt("release_year");
				int author_id = rs.getInt("author_id");
				Book book = new Book(title, volumeSheets, release_year, type,
						author_id);
				System.out.println(book);
				books.add(book);
			}
			return books;
		}

	}

	public static Map.Entry<Author, List<Book>> selectBooksByAuthor(int authorId)
			throws SQLException {
		try (Connection connection = ConnectionDB.getConnection();) {
			String sql = "SELECT books.title, books.type, author.name, author.secondname "
					+ "FROM books join author ON books.author_id = author.id "
					+ "WHERE author_id = ?;";
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, authorId);
			ResultSet rs = stm.executeQuery();

			List<Book> books = new ArrayList<>();
			Author author = null;
			while (rs.next()) {
				String title = rs.getString("title");
				String type = rs.getString("type");
				String name = rs.getString("name");
				String secondname = rs.getString("secondname");
				author = new Author(name, secondname);
				Book book = new Book(title, type);
				books.add(book);
			}
			Map.Entry<Author, List<Book>> booksByAuthor = new AbstractMap.SimpleEntry<>(
					author, books);
			System.out.println(booksByAuthor.getKey());
			System.out.println(booksByAuthor.getValue());
			return booksByAuthor;
		}
	}

	public static List<Rating> selectHighestRatingBook(int booksId)
			throws SQLException {
		try (Connection connection = ConnectionDB.getConnection();) {
			String sql = "SELECT * FROM books JOIN ratings ON books.id = ratings.books_id ORDER BY rating DESC;";
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			List<Book> books = new ArrayList<>();
			List<Rating> ratings = new ArrayList<>();
			while (rs.next()) {
				String title = rs.getString("title");
				int rating = rs.getInt("rating");
				Rating ratingAsc = new Rating(rating);
				System.out.println(ratingAsc);
				ratings.add(ratingAsc);
			}
			return ratings;
		}
	}

	public static List<Book> selectTheNewestBook() throws SQLException {
		try (Connection connection = ConnectionDB.getConnection();) {
			String sql = "SELECT * FROM books WHERE release_year = (SELECT max( release_year ) FROM books );";
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			List<Book> books = new ArrayList<>();
			while (rs.next()) {
				int release_year = rs.getInt("release_year");
				String title = rs.getString("title");
				String type = rs.getString("type");
				Book book = new Book(type, title, release_year);
				System.out.println(book);
				books.add(book);
			}
			return books;
		}
	}

	public static List<Book> selectTheNewestFiveBooks() throws SQLException {
		try (Connection connection = ConnectionDB.getConnection();) {
			String sql = "SELECT * FROM books ORDER BY release_year DESC LIMIT 5;";
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			List<Book> books = new ArrayList<>();
			while (rs.next()) {
				int release_year = rs.getInt("release_year");
				String title = rs.getString("title");
				String type = rs.getString("type");
				Book book = new Book(type, title, release_year);
				System.out.println(book);
				books.add(book);
			}
			return books;
		}
	}

	public static List<Book> authorAllBookAfterYear(int year)
			throws SQLException {
		try (Connection connection = ConnectionDB.getConnection();) {
			String sql = "SELECT author.name, author.secondname, count( * )"
					+ " FROM books "
					+ "JOIN author ON author.id = books.author_id "
					+ "WHERE books.release_year > ? GROUP BY author.id";
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, year);
			ResultSet rs = stm.executeQuery();
			List<Book> books = new ArrayList<>();
			while (rs.next()) {
				String name = rs.getString("name");
				String secondname = rs.getString("secondname");
				Book book = new Book(name, secondname);
				System.out.println(book);
				books.add(book);
			}
			return books;
		}
	}
	
	public static List<MagazineContent> readMagazine() throws SQLException{
		try(Connection connection = ConnectionDB.getConnection();){
			String sql = "SELECT content " +
					"FROM magazines_content " +
					"JOIN magazines ON magazines_content.magazine_id = magazines.id";
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			List<MagazineContent> magazines = new ArrayList<>();
			while(rs.next()){
				String content = rs.getString("content");
				MagazineContent mc = new MagazineContent(content);
				System.out.println(mc);
				magazines.add(mc);
			}
			return magazines;
		}
	}

	public static void main(String[] args) throws SQLException {
		selectBooksByType("criminal");
		selectBooksByAuthor(12);
		selectHighestRatingBook(2);
		selectTheNewestBook();
		selectTheNewestFiveBooks();
		authorAllBookAfterYear(1999);
	}
}
