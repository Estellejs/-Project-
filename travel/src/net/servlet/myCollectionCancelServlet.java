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

public class myCollectionCancelServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("我的好友页面servlet跳转成功");
        String data=request.getParameter("id");
        int ImageID=Integer.parseInt(data);
        int UID=(int)request.getSession().getAttribute("userID");

        IImageService imageService=new imageServiceImpl();

        boolean isImageCollected=imageService.isImageCollected(ImageID,UID);

        System.out.println("isImageCollected  "+isImageCollected);
        int isCollected=imageService.cancelCollection(ImageID,UID);
        System.out.println("isCollected  "+isCollected);
        isImageCollected=imageService.isImageCollected(ImageID,UID);

        System.out.println("isImageCollected  "+isImageCollected);
        System.out.println("UID   "+UID);
        request.setAttribute("isImageCollected",isImageCollected);

        //获取页面信息

        List<image> imageList=new ArrayList<image>();
        imageList=imageService.getMyCollection(UID);
        request.setAttribute("image",imageList);

        request.getRequestDispatcher("/myCollection.jsp").forward(request,response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("detailsServlet post index");
        doGet(request,response);
    }


}
