package com.java.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Assistanz Servlet implementation class LoginController
 */
@WebServlet(name = "LoginController", displayName = "Login Controller", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
    /**
     * Serial version uid.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        /**
         * Getting parameter Login form when user submits the form from request
         * to LoginController
         */
        String aname = request.getParameter("username");
        String apwd = request.getParameter("password");
        
        /* validation for Admin. */
        if (aname.equals("krishna") && apwd.equals("passw0rd")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", aname);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/admin/home.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("adminLogin.jsp");
            rd.include(request, response);
        }
        
    }
    
}
