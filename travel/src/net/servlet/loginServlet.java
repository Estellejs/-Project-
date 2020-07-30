package net.servlet;

import net.beans.user;
import net.service.IUserService;
import net.service.userServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public  class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        String name=request.getParameter("name");
        String pass=request.getParameter("password");
        IUserService service=new userServiceImpl();
        user user=null;
        user=service.checkUser(name,pass);
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        System.out.println("servlet    "+request.getAttribute("name"));
        if (user==null){
            request.setAttribute("name",name);
            request.setAttribute("password",pass);
            request.setAttribute("error","用户名或密码错误");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
            return;
        }else if (user!=null){
            response.getWriter().write("登陆成功");
            request.getSession().setAttribute("username",user.getUserName());
            request.getSession().setAttribute("userID",user.getUID());
            if (request.getSession().getAttribute("currentPageUrl")==null)
                response.sendRedirect(request.getContextPath()+"/2index.jsp");
            else
                response.sendRedirect(request.getContextPath()+request.getSession().getAttribute("currentPageUrl")+"2.jsp");

        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("detailsServlet post index");
        doPost(request,response);
    }
}
