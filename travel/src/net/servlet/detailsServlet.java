package net.servlet;

import net.beans.image;
import net.service.IImageService;
import net.service.imageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class detailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("详情页面servlet跳转成功");
        String currentPageUrl=(String)request.getSession().getAttribute("currentPageUrl");


        String data=request.getParameter("id");
        System.out.println("request.getParameter(\"id\")   "+request.getParameter("id"));
        int imageID=Integer.parseInt(data);

        IImageService service=new imageServiceImpl();
        image image=null;
        image=service.imageDetails(imageID);
        request.setAttribute("iamge",image);
        System.out.println("详情页面servlet数据获取完成");

        if (request.getSession().getAttribute("username")==null){
            request.getRequestDispatcher("/details.jsp").forward(request,response);
        }else {
            int UID=(int)request.getSession().getAttribute("userID");
            boolean isImageCollected=service.isImageCollected(imageID,UID);
            System.out.println("UID   "+UID);
            System.out.println("isImageCollected  "+isImageCollected);
            request.setAttribute("isImageCollected",isImageCollected);
            System.out.println("request.getSession().getAttribute(\"currentPageUrl\")"+request.getSession().getAttribute("currentPageUrl"));
            request.getRequestDispatcher("/details2.jsp").forward(request,response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("detailsServlet post index");
        doGet(request,response);
    }
}
