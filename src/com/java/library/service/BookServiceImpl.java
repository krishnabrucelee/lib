/**
 * 
 */
package com.java.library.service;

import com.java.library.model.dao.BookDao;

/**
 * @author Assistanz
 *
 */
public class BookServiceImpl implements BookService {

	/**
	 * Get All books from database
	 */
	public String getBookList() {
		BookDao dao = new BookDao();
		dao.getAllBooks();
		return null;
		
	}

	/**
	 * Update book from its id 
	 */
	public String updateBook(Integer bookId) {
		BookDao dao = new BookDao();
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
	 * Delete book from its id
	 */
	public String deleteBook(Integer bookId) {
		BookDao dao = new BookDao();
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
	 * Add book 
	 */
	public String addBook(String author, String title, String id) {
		BookDao dao = new BookDao();
		Integer add = dao.addBookBook(author, title, id);
		
		if (add == 0) {
			return "Book Already exits!!";
		} else if (add == 1) {
			return "Book Sucessfully Added!!";
		} else {
			return "Internal Error!!";
		}

	}

}
