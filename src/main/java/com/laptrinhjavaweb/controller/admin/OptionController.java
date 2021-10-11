package com.laptrinhjavaweb.controller.admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/admin-option"})
public class OptionController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String view = "";
        if(action != null && action.equals("warning-gmail")){

            view = "/views/admin/advance/add.jsp";
        }if(action != null && action.equals("submit-gmail")){
            String gmailAddress = request.getParameter("gmailAdd");
            //Process send gmail


            view = "/views/admin/advance/add.jsp";
        }


    // response request for user
    RequestDispatcher requestDispatcher = request.getRequestDispatcher(view);
        requestDispatcher.forward(request, response);
    }
}
