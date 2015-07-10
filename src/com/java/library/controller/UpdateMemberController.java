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
import com.java.library.model.entity.Member;
import com.java.library.service.MemberService;
import com.java.library.service.MemberServiceImpl;

/**
 * @author Assistanz Servlet implementation class UpdateMemberController
 */
@WebServlet(name = "UpdateMemberController", displayName = "Update Member Controller", urlPatterns = {
        "/updateMember" })
public class UpdateMemberController extends HttpServlet {
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
        MemberDao dao = new MemberDaoImpl();
        String forward = "/WEB-INF/views/member/edit.jsp";
        Integer memberId = Integer.parseInt(request.getParameter("id"));

        Member member = dao.getMemberById(memberId);
        request.setAttribute("member", member);
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
                member.setId(Integer.parseInt(id));
                request.setAttribute("alert", memberServ.updateMember(member));
            }

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/member/members.jsp");
            request.setAttribute("members", memberServ.getMemberList());

            rd.forward(request, response);

        } else {
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    }
}
