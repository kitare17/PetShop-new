package controller;

import entity.Food;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ProductRepository;
import service.ProductService;

import java.io.IOException;
import java.util.ArrayList;

/*
CHUA PHAT TRIEN :D
 */
@WebServlet(name = "foodShowServlet", value = "/food")
public class FoodShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String page=request.getParameter("page");
        if (page==null) page="1";
        ArrayList<Food> listFood = ProductRepository.getListFoodPage(page);
        double size = ProductRepository.getFoodSize();
        int max= (int) Math.ceil(size/9);
        request.setAttribute("listFood", listFood);
        request.setAttribute("maxPage",max);

        request.getRequestDispatcher("food.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
