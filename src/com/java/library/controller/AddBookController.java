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
 * @author Assistanz Servlet implementation class AddBookController
 */
@WebServlet(name = "AddBookController", displayName = "Add Book Controller", urlPatterns = { "/addBook" })
public class AddBookController extends HttpServlet {
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
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/book/add.jsp");
        rd.forward(request, response);
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("error");
        BookService bookServ = new BookServiceImpl();
        Book book = new Book();
        HttpSession session = request.getSession(false);
        if (session != null) {
            book.setAuthor(request.getParameter("author"));
            book.setTitle(request.getParameter("title"));
            String id = request.getParameter("id");
            
            if (id == null || id.isEmpty()) {
                request.setAttribute("book", bookServ.addBook(book));
            } else {
                int bookId = Integer.parseInt(request.getParameter(id));
                request.setAttribute("book", bookServ.updateBook(bookId));
            }
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/book/books.jsp");
            request.setAttribute("books", bookServ.getBookList());
            
            rd.forward(request, response);
            
        } else {
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    }
}
