/**
 * 
 */
package com.java.library.model.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.java.library.model.entity.Book;
import com.java.library.utils.DbUtil;

/**
 * @author Assistanz
 *
 */
public class BookDao {
	private Connection connection;

	public BookDao() {
		connection = DbUtil.getConnection();
	}

	/**
	 * List all books
	 * @return
	 */
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<Book>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from books where isDeleted = 0");
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));

				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	public Integer updateBook(Integer bookId) {
		Book book = new Book();
		try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("update books set title=?, author=?" + "where bookid=?");
				// Parameters start with 1
				preparedStatement.setString(1, book.getTitle());
				preparedStatement.setString(2, book.getAuthor());
				preparedStatement.setInt(3, book.getId());
				preparedStatement.executeUpdate();
				
		} catch (SQLException e) {
			e.printStackTrace();
			return 2;
		}
		return 1;
	}

	public Integer deleteBook(Integer bookId) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update books set isDeleted = ? where bookid=?");
			// Parameters start with 1
			preparedStatement.setBoolean(1, true);
			preparedStatement.setInt(2, bookId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 2;
		}
		return 1;
	}

	public Integer addBookBook(String author, String title, String id) {
		Book book = new Book();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into books(title,author,isDeleted) values (?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setBoolean(3, false);
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 2;
		}
		return 1;
	}
}
