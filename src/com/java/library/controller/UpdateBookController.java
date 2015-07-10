package com.java.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.library.model.dao.BookDao;
import com.java.library.model.dao.BookDaoImpl;
import com.java.library.model.entity.Book;
import com.java.library.service.BookService;
import com.java.library.service.BookServiceImpl;

/**
 * @author Assistanz Servlet implementation class UpdateBookController
 */
@WebServlet(name = "UpdateBookController", displayName = "Update Book Controller", urlPatterns = { "/updateBook" })
public class UpdateBookController extends HttpServlet {
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
        BookDao dao = new BookDaoImpl();
        String forward = "/WEB-INF/views/book/edit.jsp";
        Integer bookId = Integer.parseInt(request.getParameter("id"));

        Book book = dao.getBookById(bookId);
        request.setAttribute("book", book);
        RequestDispatcher rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       BookService bookServ = new BookServiceImpl();
        Book book = new Book();
        HttpSession session = request.getSession(false);
        if (session != null) {
            book.setTitle(request.getParameter("title"));
            book.setAuthor(request.getParameter("author"));
            String id = request.getParameter("id");

            if (id == null || id.isEmpty()) {
                request.setAttribute("alert", bookServ.addBook(book));
            } else {
                book.setId(Integer.parseInt(id));
                request.setAttribute("alert", bookServ.updateBook(book));
            }

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/book/books.jsp");
            request.setAttribute("books", bookServ.getBookList());

            rd.forward(request, response);

        } else {
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    }

}
