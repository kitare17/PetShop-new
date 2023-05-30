package controller;

import entity.Cart;
import entity.Items;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.OrderRepository;
import repository.ProductRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "getFoodDetailServlet", value = "/getfooddetail")
public class GetFoodDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null) {
            response.sendRedirect("index.jsp");
        } else {
            Product p = ProductRepository.getFood(id);
            System.out.println(p);
            request.setAttribute("product", p);
            request.getRequestDispatcher("product-detail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
