/**
 *
 */
package com.java.library.service;

import com.java.library.model.dao.BookDao;
import com.java.library.model.dao.BookDaoImpl;

/**
 * @author Assistanz
 */
public class BookServiceImpl implements BookService {

    /**
     * Get All books from database.
     */
    @Override
    public String getBookList() {
        BookDao dao = new BookDaoImpl();
        dao.getAllBooks();
        return null;
    }

    /**
     * Update book from its id.
     */
    @Override
    public String updateBook(Integer bookId) {
        BookDao dao = new BookDaoImpl();
        Integer update = dao.updateBook(bookId);

        if (update == 0) {
            return "Book Already exits!!";
        } else if (update == 1) {
            return "Book Sucessfully Added!!";
        } else {
            return "Internal Error!!";
        }

    }

    /**
     * Delete book from its id.
     */
    @Override
    public String deleteBook(Integer bookId) {
        BookDao dao = new BookDaoImpl();
        Integer delete = dao.deleteBook(bookId);

        if (delete == 0) {
            return "Book Already exits!!";
        } else if (delete == 1) {
            return "Member Sucessfully Added!!";
        } else {
            return "Internal Error!!";
        }
    }

    /**
     * Add book to database.
     */
    @Override
    public String addBook(String author, String title, String id) {
        BookDao dao = new BookDaoImpl();
        Integer add = dao.addBook(author, title, id);

        if (add == 0) {
            return "Book Already exits!!";
        } else if (add == 1) {
            return "Book Sucessfully Added!!";
        } else {
            return "Internal Error!!";
        }

    }

    /**
     * Search Book by its id.
     */
    @Override
    public String searchBook(Integer bookId) {
        BookDao dao = new BookDaoImpl();
        dao.searchBookById(bookId);
        return null;
    }

}
