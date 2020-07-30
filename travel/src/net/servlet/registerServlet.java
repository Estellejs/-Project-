package net.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.beans.*;
import net.service.*;

public class registerServlet  extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatPassword");
		String email = request.getParameter("email");

        HttpSession session=request.getSession();
		if(password.equals(repeatPassword)) {

			user user = new user();
			user.setPass(password);
			user.setEmail(email);
			user.setUserName(name);

			IUserService service = new userServiceImpl();

			int id = service.saveUser(user);
			System.out.println("id   "+id);
			if(id == -1) {
	            session.setAttribute("message","用户名已注册");
				response.sendRedirect(request.getContextPath()+"/jsp/register.jsp");
				return;
			}else if(id == -2) {
				session.setAttribute("message","");
				response.sendRedirect(request.getContextPath()+"/jsp/register.jsp");
				return;
			}else if(id>0){
				request.getSession().setAttribute("userID",id);
				request.getSession().setAttribute("username",name);
				if (request.getSession().getAttribute("currentPageUrl")==null)
					response.sendRedirect(request.getContextPath()+"/index2.jsp");
				else
					response.sendRedirect(request.getContextPath()+request.getSession().getAttribute("currentPageUrl")+"2.jsp");

			}else {
				session.setAttribute("message","");
				response.sendRedirect(request.getContextPath()+"/jsp/register.jsp");
			}
		}
		else {
            session.setAttribute("message","");
			response.sendRedirect(request.getContextPath()+"/jsp/register.jsp");
			return;
		}
		return;
	}
}
