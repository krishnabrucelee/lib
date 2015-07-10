package com.java.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.library.service.MemberService;
import com.java.library.service.MemberServiceImpl;

/**
 * @author Assistanz Servlet implementation class SearchMemberController
 */

@WebServlet(name = "SearchMemberController", displayName = "Search Member Controller", urlPatterns = {
        "/searchMember" })
public class SearchMemberController extends HttpServlet {
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
        String forward = "/WEB-INF/views/search/searchMember.jsp";
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MemberService memberServ = new MemberServiceImpl();
        String name = request.getParameter("name");
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (id == null || id.isEmpty()) {
                request.setAttribute("alert", id);
            } else {
                int memberId = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("member", memberServ.searchMember(memberId));
            }
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/search/searchMemberResult.jsp");
            view.forward(request, response);

        } else {
            request.getRequestDispatcher("adminLogin.jsp").include(request, response);
        }

    }

}
