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
 * @author Assistanz
 * Servlet implementation class DeleteMemberController
 */
@WebServlet( name="DeleteMemberController", displayName="Delete Member Controller", urlPatterns = {"/deleteMember"})
public class DeleteMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService memberServ = new MemberServiceImpl();
		String action = request.getParameter("id");
		HttpSession session=request.getSession(false);  
        if(session!=null){  
        	String forward = "/WEB-INF/views/member/members.jsp";
        	int memberId = Integer.parseInt(request.getParameter(action));
        	
        	request.setAttribute("members", memberServ.deleteMember(memberId));
        	RequestDispatcher rd = request.getRequestDispatcher(forward);
    		rd.forward(request, response);
        } else {
    		request.getRequestDispatcher("index.jsp").include(request, response);
    	}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
