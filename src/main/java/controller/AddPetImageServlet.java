package controller;

import entity.Image;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ProductRepository;

import java.io.IOException;

@WebServlet(name = "AddPetImageServlet", value = "/pet-add-image")
public class AddPetImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String petID= request.getParameter("productId");
        String url=request.getParameter("urlImage");
        Image img=new Image(petID,url);
        ProductRepository.addPetImg(img);
        request.setAttribute("productId",petID);
        System.out.println("ok");
        response.sendRedirect("pet-image-manager?productId="+petID);
    }
}
