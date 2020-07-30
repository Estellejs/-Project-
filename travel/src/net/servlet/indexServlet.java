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

public class indexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("start get index");

        IImageService service=new imageServiceImpl();

        List<image> hotImages=new ArrayList<image>();
        List<image> newImage=new ArrayList<image>();

        hotImages=service.selectHotPhotos("hot");
        newImage=service.selectHotPhotos("new");

        System.out.println("hot size "+hotImages.size());

        request.setAttribute("hot",hotImages);
        request.setAttribute("new",newImage);

        request.getSession().setAttribute("stopRefreshIndex",1);
        if (request.getSession().getAttribute("username")==null){
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/index2.jsp").forward(request,response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("start post index");
        doGet(request,response);
    }
}
