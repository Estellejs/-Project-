package net.servlet;

import net.beans.image;
import net.beans.user;
import net.service.IImageService;
import net.service.IUserService;
import net.service.imageServiceImpl;
import net.service.userServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class cancelOrCollectionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("我的好友页面servlet跳转成功");
        String data=request.getParameter("id");
        int ImageID=Integer.parseInt(data);
        int UID=(int)request.getSession().getAttribute("userID");

        IImageService imageService=new imageServiceImpl();

        boolean isImageCollected=imageService.isImageCollected(ImageID,UID);

        System.out.println("isImageCollected  "+isImageCollected);
        int isCollected=imageService.cancelOrCollectImage(ImageID,UID);
        System.out.println("isCollected  "+isCollected);
        isImageCollected=imageService.isImageCollected(ImageID,UID);

        System.out.println("isImageCollected  "+isImageCollected);
        System.out.println("UID   "+UID);
        request.setAttribute("isImageCollected",isImageCollected);

        //获取页面信息

        image image=imageService.imageDetails(ImageID);
        request.setAttribute("iamge",image);

        request.getRequestDispatcher("/details2.jsp").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("detailsServlet post index");
        doGet(request,response);
    }

}
