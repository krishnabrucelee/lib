package com.java.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.library.model.entity.Book;
import com.java.library.service.BookService;
import com.java.library.service.BookServiceImpl;

/**
 * @author Assistanz Servlet implementation class SearchController
 */

@WebServlet(name = "SearchController", displayName = "Search Controller", urlPatterns = { "/search" })
public class SearchController extends HttpServlet {
    /**
     * Serial version uid.
     */
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "/WEB-INF/views/search/search.jsp";
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookService bookServ = new BookServiceImpl();
        Book book = new Book();
        String title = request.getParameter("title");
        HttpSession session = request.getSession(false);
        if (session != null) {
            book.setTitle(title);

            request.setAttribute("books", bookServ.searchBook(title));
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/search/searchResult.jsp");
            //request.setAttribute("books", bookServ.getBookList());
            rd.forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    }

}
