package com.java.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.library.model.entity.Member;
import com.java.library.service.MemberService;
import com.java.library.service.MemberServiceImpl;

/**
 * @author Assistanz Servlet implementation class MemberController
 */

@WebServlet(name = "AddMemberController", displayName = "Add Member Controller", urlPatterns = { "/addMember" })
public class AddMemberController extends HttpServlet {
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
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/add.jsp");
        rd.forward(request, response);
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MemberService memberServ = new MemberServiceImpl();
        Member member = new Member();
        HttpSession session = request.getSession(false);
        if (session != null) {
            member.setName(request.getParameter("name"));
            member.setEmail(request.getParameter("email"));
            String id = request.getParameter("id");
            
            if (id == null || id.isEmpty()) {
                request.setAttribute("alert", memberServ.addMember(member));
            } else {
                int memberId = Integer.parseInt(request.getParameter(id));
                request.setAttribute("alert", memberServ.updateMember(memberId));
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/members.jsp");
            request.setAttribute("members", memberServ.getMemberList());
            
            rd.forward(request, response);
            
        } else {
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    }
    
}
