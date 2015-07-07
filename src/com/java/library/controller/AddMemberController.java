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
 * Servlet implementation class MemberController
 */
@WebServlet( name="AddMemberController", displayName="Add Member Controller", urlPatterns = {"/addMember"})
public class AddMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService memberServ = new MemberServiceImpl();
		HttpSession session=request.getSession(false);  
        if(session!=null){  
        	String name = request.getParameter("name");
        	String email = request.getParameter("email");
        	String id = request.getParameter("id");

		if (id == null || id.isEmpty()) {		
			request.setAttribute("alert", memberServ.addMember(name, email, id));
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
