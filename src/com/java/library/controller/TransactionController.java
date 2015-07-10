package com.java.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Assistanz Servlet implementation class TransactionController.
 */

@WebServlet(name = "TransactionController", displayName = "Transaction Controller", urlPatterns = {
        "/transaction" })
public class TransactionController extends HttpServlet {

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

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/transaction/transaction.jsp");
            rd.forward(request, response);


    }

}
