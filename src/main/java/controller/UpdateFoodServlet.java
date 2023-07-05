package controller;

import entity.Food;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ProductRepository;

import java.io.IOException;

@WebServlet(name = "UpdateFoodServlet", value = "/updatefood")
public class UpdateFoodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodID=request.getParameter("foodID");

        Food food=ProductRepository.getFoodInfor(foodID) ;
        System.out.println(food);
        request.setAttribute("food",food);
        request.getRequestDispatcher("food-update.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodID= request.getParameter("productId");
        String foodName=request.getParameter("foodName");
        double foodPrice=Double.parseDouble( request.getParameter("foodPrice"))  ;
        String foodType=request.getParameter("foodType");
        String foodUrlImg=request.getParameter("foodUrlImg");
        String foodOrigin=request.getParameter("foodOrigin");
        int foodStatus=Integer.parseInt(request.getParameter("status")) ;
        System.out.println("Them " +foodID +" "+ foodName+" "+ foodPrice+" "+ foodType+" "+foodUrlImg +foodOrigin );
        Food food=new Food(foodID,foodName,foodType,foodOrigin,foodPrice,1,null,foodStatus);
        ProductRepository.UpdateFood(food);
        request.setAttribute("thongbao","Cập nhật thành công");
        request.setAttribute("food",food);

        request.getRequestDispatcher("food-update.jsp").forward(request,response);
    }
}
