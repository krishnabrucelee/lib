/**
 *
 */
package com.java.library.model.dao;

import java.util.List;

import com.java.library.model.entity.Book;

/**
 * @author Assistanz
 */
public interface BookDao {
    
    /**
     * Get all Book Details.
     *
     * @return list of Books.
     */
    List<Book> getAllBooks();
    
    /**
     * update Book from its id.
     *
     * @param bookId
     *            id
     * @return update book details.
     */
    Integer updateBook(Integer bookId);
    
    /**
     * Delete book from its id.
     *
     * @param bookId
     *            id
     * @return isDeleted 0/1
     */
    Integer deleteBook(Integer bookId);
    
    /**
     * Add Book to database.
     *
     * @param book
     *            Book details
     * @return add book details
     */
    String addBook(Book book);
    
    /**
     * Search Book by its id.
     *
     * @param bookId
     *            id
     * @return search book details
     */
    List<Book> searchBookById(Integer bookId);
    
}
