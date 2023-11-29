package controller;

import entity.Preferential;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.OrderRepository;
import service.MyRandom;

import java.io.IOException;

@WebServlet(name = "CreateDiscountServlet", value = "/creatediscount")
public class CreateDiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id= MyRandom.getRandomDiscount();
        String preferentialName = request.getParameter("preferentialName");
        String startDay = request.getParameter("startDay");
        String endDay = request.getParameter("endDay");
        double rate=0;
        try {
            rate = Double.parseDouble(request.getParameter("rate"));
        } catch (Exception e){
            e.printStackTrace();
        }
        Preferential p=new Preferential( id, preferentialName ,  startDay,  endDay,  rate);
        OrderRepository.createDiscount(p);
        request.setAttribute("thongbao","Thêm thành công");
        request.getRequestDispatcher("adddiscount.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
