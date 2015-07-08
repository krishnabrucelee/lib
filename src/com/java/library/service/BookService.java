/**
 * 
 */
package com.java.library.service;

/**
 * @author Assistanz
 *
 */
public interface BookService {

	/*Get Book List*/
	public String getBookList();

	/*Update book from id*/
	public String updateBook(Integer bookId);

	/*Delete Book from id*/
	public String deleteBook(Integer bookId);

	/*Add books*/
	public String addBook(String author, String title, String id);

	/*Search book*/
	public String searchBook(Integer bookId);


}
