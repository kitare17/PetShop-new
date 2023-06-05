package controller;

import entity.Food;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ProductRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FoodListManagerServlet", value = "/food-list-manager")
public class FoodListManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Food> listFood = ProductRepository.getListFood();
        request.setAttribute("listFood",listFood);
        request.getRequestDispatcher("food-list-manager.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
