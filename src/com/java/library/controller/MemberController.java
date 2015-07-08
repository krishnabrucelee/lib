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
 * @author Assistanz Servlet implementation class MemberController.
 */
@WebServlet(name = "MemberController", displayName = "Member Controller", urlPatterns = { "/member" })
public class MemberController extends HttpServlet {
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
        MemberService memberServ = new MemberServiceImpl();
        HttpSession session = request.getSession(false);
        if (session != null) {
            String forward = "/WEB-INF/views/member/members.jsp";
            request.setAttribute("members", memberServ.getMemberList());
            RequestDispatcher rd = request.getRequestDispatcher(forward);
            rd.forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
