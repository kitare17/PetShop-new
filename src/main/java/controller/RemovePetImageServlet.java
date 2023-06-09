package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ProductRepository;

import java.io.IOException;

@WebServlet(name = "RemovePetImageServlet", value = "/remove-pet")
public class RemovePetImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String petID= request.getParameter("productId");
        String url=request.getParameter("urlImage");
        ProductRepository.removePetImage(petID,url);
        request.setAttribute("productId",petID);
        System.out.println("ok");
        response.sendRedirect("pet-image-manager?productId="+petID);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
