package net.servlet;

import net.beans.image;
import net.service.IImageService;
import net.service.imageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class myImageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("我的图片页面servlet跳转成功");
        int UID=(int)request.getSession().getAttribute("userID");

        IImageService service=new imageServiceImpl();


        List<image> imageList=new ArrayList<image>();

        imageList=service.getMyImageList(UID);

        System.out.println("我的图片数量 "+imageList.size());

        request.setAttribute("image",imageList);

        request.getRequestDispatcher("/MyPicture.jsp").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("detailsServlet post index");
        doGet(request,response);
    }


}
