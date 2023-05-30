package controller;

import entity.Food;
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
@WebServlet(name = "foodShowServlet", value = "/food")
public class FoodShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("UTF-8");
//        ArrayList<Food> listFood = ProductService.listFood();
//        ArrayList<Food> subListFood = new ArrayList<Food>();
//        int size=listFood.size();//get size
//        int amountPet=8;//amount on page
//        int maxPage=(size%amountPet==0)?size/amountPet:size/amountPet+1;
//        int pageAmount=5;
//        int page;
//        try {
//            if(request.getParameter("page").equals("fisrt")) page =1;
//            else if(request.getParameter("page").equals("last")) page =maxPage;
//            else page=Integer.parseInt(request.getParameter("page"));
//        } catch (Exception e) {
//            page=1;
//        }
//
//        System.out.println(page+" "+size);
//
//
//        int realAmountPet=(page*amountPet>size)?size:page*amountPet;//set amount user if exceed real size
//        System.out.println(realAmountPet);
//        for(int i=page*amountPet-amountPet;i<realAmountPet;i++) {
//            subListFood.add(listFood.get(i));
//            System.out.println(i);
//        }
//        request.setAttribute("listFood", subListFood);
//
//        request.setAttribute("page", page);
//        request.setAttribute("maxPage", maxPage);
        request.getRequestDispatcher("food.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
