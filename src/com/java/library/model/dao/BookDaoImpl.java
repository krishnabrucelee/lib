/**
 *
 */
package com.java.library.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.library.model.entity.Book;
import com.java.library.utils.DbUtil;

/**
 * @author Assistanz
 */
public class BookDaoImpl implements BookDao {
    /**
     * A connection (session) with a specific database.
     */
    private Connection connection = DbUtil.getConnection();
    
    /**
     * Constant Index value.
     */
    public static final Integer ID = 3;
    
    /**
     * List all books.
     *
     * @return books
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
    
    /**
     * Update or Edit book.
     *
     * @param bookId
     *            id.
     * @return 0/1
     */
    public Integer updateBook(Integer bookId) {
        Book book = new Book();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update books set title=?, author=?" + "where bookid=?");
            // Parameters start with 1
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(ID, book.getId());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            return 2;
        }
        return 1;
    }
    
    /**
     * Delete book.
     *
     * @param bookId
     *            id
     * @return 0/1
     */
    public Integer deleteBook(Integer bookId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update books set isDeleted = ? where bookid=?");
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
    
    /**
     * Add Book.
     *
     * @param book
     *            Book details
     * @return 0/1
     */
    public String addBook(Book book) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into books(title,author,isDeleted) values (?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setBoolean(ID, false);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
    /**
     * Search Book from id.
     *
     * @param bookId
     *            id
     * @return Search book details
     */
    public List<Book> searchBookById(Integer bookId) {
        List<Book> searchBookEntities = new ArrayList<Book>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from books where bookid=?");
            preparedStatement.setInt(1, bookId);
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
                Book searchBookEntity = new Book();
                searchBookEntity.setId(rs.getInt("id"));
                searchBookEntity.setTitle(rs.getString("title"));
                searchBookEntity.setAuthor(rs.getString("author"));
                
                searchBookEntities.add(searchBookEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return searchBookEntities;
    }
    
}
