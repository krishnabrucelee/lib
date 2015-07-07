package com.java.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.library.service.BookService;
import com.java.library.service.BookServiceImpl;

/**
 * @author Assistanz
 * Servlet implementation class AddBookController
 */
@WebServlet( name="AddBookController", displayName="Add Book Controller", urlPatterns = {"/addBook"})
public class AddBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookServ = new BookServiceImpl();
		HttpSession session=request.getSession(false);  
        if(session!=null){  
        	String author = request.getParameter("author");
        	String title = request.getParameter("title");
        	String id = request.getParameter("id");

		if (id == null || id.isEmpty()) {		
			request.setAttribute("alert", bookServ.addBook(author, title, id));
		} else {
			int bookId = Integer.parseInt(request.getParameter(id));	
			request.setAttribute("alert", bookServ.updateBook(bookId));

		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/members.jsp");
		request.setAttribute("books", bookServ.getBookList());
		
		rd.forward(request, response);
		
        } else {

			request.getRequestDispatcher("index.jsp").include(request, response);
		}
	}
}
