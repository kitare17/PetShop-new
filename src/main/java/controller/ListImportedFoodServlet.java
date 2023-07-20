package controller;

import entity.ImportedFood;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ProductRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListImportedFoodServlet", value = "/food-list-import")
public class ListImportedFoodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String foodID=request.getParameter("productId");
        ArrayList<ImportedFood> listImportedFood= ProductRepository.getListImportedFood(foodID);
        request.setAttribute("listImportedFood",listImportedFood);
        request.setAttribute("productId",foodID);
        request.getRequestDispatcher("food-import-list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
