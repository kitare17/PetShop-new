package controller;

import entity.Image;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ProductRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PetImageServlet", value = "/pet-image-manager")
public class PetImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String petID= request.getParameter("productId");
   ArrayList<Image> listImage= ProductRepository.getListPetImage(petID);
   request.setAttribute("listImage",listImage);
   request.setAttribute("productId",petID);
   request.getRequestDispatcher("pet-list-image.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
