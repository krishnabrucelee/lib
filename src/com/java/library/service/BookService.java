/**
 *
 */
package com.java.library.service;

import java.util.List;

import com.java.library.model.entity.Book;

/**
 * @author Assistanz
 */
public interface BookService {

    /**
     * Get Book List.
     *
     * @return List of books
     */
    List<Book> getBookList();

    /**
     * Update Book from book id.
     *
     * @param book
     *            id
     * @return updated details.
     */
    String updateBook(Book book);

    /**
     * Delete book from book id.
     *
     * @param book
     *            id
     * @return isDeleted 0/1
     */
    String deleteBook(Book book);

    /**
     * Add Book in database.
     *
     * @param book
     *            book details
     * @return Add Book Details.
     */
    String addBook(Book book);

    /**
     * Search for Book.
     *
     * @param title
     *            id
     * @return search book details.
     */
    List<Book> searchBook(String title);

}
