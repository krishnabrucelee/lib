/**
 *
 */
package com.java.library.service;

/**
 * @author Assistanz
 */
public interface BookService {

    /**
     *  Get Book List.
     *  @return list of books
     */
    String getBookList();

    /**
     * Update Book from book id.
     * @param bookId id
     * @return updated details.
     */
    String updateBook(Integer bookId);

    /**
     * Delete book from book id.
     * @param bookId id
     * @return isDeleted 0/1
     */
    String deleteBook(Integer bookId);

    /**
     * Add Book in database.
     * @param author book author
     * @param title book title
     * @param id book id
     * @return Add Book Details.
     */
    String addBook(String author, String title, String id);

    /**
     * Search for Book.
     * @param bookId id
     * @return search book details.
     */
    String searchBook(Integer bookId);

}
