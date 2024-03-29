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
 * Servlet implementation class UpdateBookController
 */
@WebServlet( name="UpdateBookController", displayName="Update Book Controller", urlPatterns = {"/updateBook"})
public class UpdateBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookServ = new BookServiceImpl();
		String id = request.getParameter("id");
		HttpSession session=request.getSession(false);  
        if(session!=null){  
        	String forward = "/WEB-INF/views/member/books.jsp";
        	int bookId = Integer.parseInt(request.getParameter(id));
        	
        	request.setAttribute("book", bookServ.updateBook(bookId));
        	RequestDispatcher rd = request.getRequestDispatcher(forward);
    		rd.forward(request, response);
        } else {
    		request.getRequestDispatcher("index.jsp").include(request, response);
    	}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
