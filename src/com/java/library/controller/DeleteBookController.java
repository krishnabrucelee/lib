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
 * @author Assistanz
 * Servlet implementation class DeleteBookController
 */
@WebServlet(name = "DeleteBookController", displayName = "Delete Book Controller", urlPatterns = { "/deleteBook" })
public class DeleteBookController extends HttpServlet {
    /**
     * Serial version uid.
     */
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookService bookServ = new BookServiceImpl();
        Book book = new Book();
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);
        if (session != null) {
            book.setId(Integer.parseInt(id));

            request.setAttribute("alert", bookServ.deleteBook(book));
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/book/books.jsp");
            request.setAttribute("books", bookServ.getBookList());
            rd.forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    }
}
