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
    Integer updateBook(Book bookId);

    /**
     * Delete book from its id.
     *
     * @param bookId
     *            id
     * @return isDeleted 0/1
     */
    Integer deleteBook(Book bookId);

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
     * @param title book title
     *            id
     * @return search book details
     */
    List<Book> searchBookByTitle(String title);

    /**
     * Get Book by its id.
     * @param bookId id
     * @return book details
     */
    Book getBookById(Integer bookId);



}
