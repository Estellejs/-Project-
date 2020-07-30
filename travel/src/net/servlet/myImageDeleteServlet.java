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

public class myImageDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("我的图片页面servlet跳转成功");
        int UID=(int)request.getSession().getAttribute("userID");

        IImageService service=new imageServiceImpl();
  //删除
        String data=request.getParameter("id");
        int ImageID=Integer.parseInt(data);

        int deleteImage=service.deleteImage(ImageID);
        System.out.println("delete  "+deleteImage);


        //页面信息
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
