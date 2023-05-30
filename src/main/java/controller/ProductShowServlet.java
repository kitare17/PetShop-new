package controller;

import entity.Food;
import entity.Pet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductService;

import java.io.IOException;
import java.util.ArrayList;

/*
CHUA PHAT TRIEN :D
 */
@WebServlet(name = "productShowServlet", value = "/product")
public class ProductShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        ArrayList<Pet> listPet = ProductService.listPet();
        ArrayList<Food> listFood = ProductService.listFood();
        ArrayList<Pet> subListPet = new ArrayList<Pet>();
        ArrayList<Food> subListFood = new  ArrayList<Food>();
        for(int i=0;i<4;i++){
            subListFood.add(listFood.get(i));
            subListPet.add(listPet.get(i));
        }
        request.setAttribute("listPet", subListPet);
        request.setAttribute("listFood", subListFood);

        request.getRequestDispatcher("product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
