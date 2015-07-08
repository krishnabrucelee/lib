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
 *  Servlet implementation class SearchBookController
 */

@WebServlet( name="SearchBookController", displayName="Search Book Controller", urlPatterns = {"/searchBook"})
public class SearchBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String forward = "/WEB-INF/views/search/searchBook.jsp";
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookService bookServ = new BookServiceImpl();
		String id = request.getParameter("id");
		HttpSession session = request.getSession(false);
		if (session != null) {
			if (id == null || id.isEmpty()) {
				request.setAttribute("alert", id);
				
			} else {
				int bookId = Integer.parseInt(request.getParameter("id"));

				request.setAttribute("books", bookServ.searchBook(bookId));
			}
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/search/searchResult.jsp");
			view.forward(request, response);

		} else {

			request.getRequestDispatcher("adminLogin.jsp").include(request, response);
		}

	}

}
