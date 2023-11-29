package controller;

import entity.ImportedFood;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ProductRepository;

import java.io.IOException;

@WebServlet(name = "FoodImportServlet", value = "/food-import")
public class FoodImportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodID=request.getParameter("productId");
        request.setAttribute("productId",foodID);
        request.getRequestDispatcher("food-import.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodID=request.getParameter("productId");
        String importName=request.getParameter("importName");
        int importAmount=Integer.parseInt(request.getParameter("importAmount")) ;
        String importDate=request.getParameter("importDate");
        ImportedFood importFood=new ImportedFood(foodID,importName,importAmount,importDate);
        System.out.println(importFood);
        ProductRepository.addImportedFood(importFood);
        request.setAttribute("productId",foodID);
        request.setAttribute("thongbao","Nhập thành công");
        request.getRequestDispatcher("food-import.jsp").forward(request,response);
    }
}
