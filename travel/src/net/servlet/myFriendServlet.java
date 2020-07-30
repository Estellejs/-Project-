package net.servlet;

import net.beans.user;
import net.service.IUserService;
import net.service.userServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class myFriendServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("我的friend servlet跳转成功");

        int UID=(int)request.getSession().getAttribute("userID");
        IUserService service=new userServiceImpl();

        List<user> userList=new ArrayList<user>();
        userList=service.getMyFriend(UID);

        System.out.println("我的friend"+userList.size());

        request.setAttribute("friend",userList);
        request.getRequestDispatcher("/myFriend.jsp").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("detailsServlet post index");
        doGet(request,response);
    }

}
