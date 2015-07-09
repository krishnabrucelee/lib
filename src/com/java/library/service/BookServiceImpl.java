/**
 *
 */
package com.java.library.service;

import java.util.List;

import com.java.library.model.dao.BookDao;
import com.java.library.model.dao.BookDaoImpl;
import com.java.library.model.entity.Book;

/**
 * @author Assistanz
 */
public class BookServiceImpl implements BookService {
    
    /**
     * Get All books from database.
     */
    @Override
    public List<Book> getBookList() {
        BookDao dao = new BookDaoImpl();
        return dao.getAllBooks();
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
    public String addBook(Book book) {
        BookDao dao = new BookDaoImpl();
        return dao.addBook(book);
        
    }
    
    /**
     * Search Book by its id.
     */
    @Override
    public List<Book> searchBook(Integer bookId) {
        BookDao dao = new BookDaoImpl();
        return dao.searchBookById(bookId);
        
    }
    
}
