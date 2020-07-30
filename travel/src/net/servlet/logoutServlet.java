package net.servlet;

import net.beans.user;
import net.service.IUserService;
import net.service.userServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class logoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("userID");
        response.sendRedirect(request.getContextPath() + "/index.jsp");

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("detailsServlet post index");
        doPost(request,response);
    }

}
