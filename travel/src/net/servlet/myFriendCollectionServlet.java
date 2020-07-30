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

public class myFriendCollectionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("我的好友页面servlet跳转成功");
        String data=request.getParameter("FID");
        int FID=Integer.parseInt(data);

        IUserService userService=new userServiceImpl();
        IImageService imageService=new imageServiceImpl();
        user user=userService.getUserInformationByID(FID);

        List<image> imageList=new ArrayList<image>();
        request.setAttribute("user",user);
        if (user.getState()==0){
            System.out.println("好友拒绝查看");
            request.getRequestDispatcher("/myFriendCollection.jsp").forward(request,response);
        }else if (user.getState()==1){
            imageList=imageService.getMyCollection(FID);
            request.setAttribute("image",imageList);
            System.out.println("好友的收藏获取数据成功 张数 "+imageList.size());
            request.getRequestDispatcher("/myFriendCollection.jsp").forward(request,response);
        }


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("detailsServlet post index");
        doGet(request,response);
    }


}
