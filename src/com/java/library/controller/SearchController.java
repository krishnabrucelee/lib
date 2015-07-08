package com.java.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Assistanz
 * Servlet implementation class SearchController
 */

@WebServlet( name="SearchController", displayName="Search Controller", urlPatterns = {"/searchController"})
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String forward = "/WEB-INF/views/search/search.jsp";
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		} else {

			request.getRequestDispatcher("index.jsp").include(request, response);
		}
	}

}
