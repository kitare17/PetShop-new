package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ProductRepository;

import java.io.IOException;

@WebServlet(name = "RemoveFoodImageServlet", value = "/remove-food")
public class RemoveFoodImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodID= request.getParameter("productId");
        String url=request.getParameter("urlImage");
        ProductRepository.removeFoodImage(foodID,url);
        request.setAttribute("productId",foodID);
        System.out.println("ok");
        response.sendRedirect("food-image-manager?productId="+foodID);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
