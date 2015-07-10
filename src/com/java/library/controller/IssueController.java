package com.java.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.library.model.dao.MemberDao;
import com.java.library.model.dao.MemberDaoImpl;
import com.java.library.model.entity.Book;
import com.java.library.model.entity.Member;
import com.java.library.service.BookService;
import com.java.library.service.BookServiceImpl;
import com.java.library.service.MemberService;
import com.java.library.service.MemberServiceImpl;

/**
 * @author Assistanz Servlet implementation class IssueController
 */

@WebServlet(name = "IssueController", displayName = "Issue Controller", urlPatterns = { "/issue" })
public class IssueController extends HttpServlet {
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

        /*MemberService memberServ = new MemberServiceImpl();
        MemberDao  dao = new MemberDaoImpl();
        //Member member = new Member();
        //Integer id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession(false);
        if (session != null) {
                member.setId(id);
                 //memberId = Integer.parseInt(request.getParameter("id"));

                request.setAttribute("member", dao.getMemberById(id));
            String forward = "/WEB-INF/views/member/edit.jsp";
            Integer memberId = Integer.parseInt(request.getParameter("id"));

            Member member = dao.getMemberById(memberId);
            request.setAttribute("member", member);
                RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/transaction/issue.jsp");
            view.forward(request, response);

        } else {
            request.getRequestDispatcher("index.jsp").include(request, response);
        }*/


        MemberDao dao = new MemberDaoImpl();
        Member member = new Member();
        String forward = "/WEB-INF/views/member/edit.jsp";
        Integer memberId = Integer.(request.getParameter("id"));
        member.setId(memberId);
        Member member = dao.getMemberById(memberId);
        request.setAttribute("member", member);
        RequestDispatcher rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
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
