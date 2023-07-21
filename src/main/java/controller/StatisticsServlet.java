package controller;

import entity.Revenue;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.StatisticsRepository;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

@WebServlet(name = "StatisticsServlet", value = "/statistics")
public class StatisticsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numberOfUsers = StatisticsRepository.getUserAmount();

        int numberOfOrderToConfirm = StatisticsRepository.getNumberOfOrdersToConfirm();

        int numberOfPetsLeft = StatisticsRepository.getNumberOfPetsLeft();

        double orderRevenue=StatisticsRepository.getOrderRevenue();
        double serviceRevenue=StatisticsRepository.getServiceRevenueByYear();




        ArrayList<Revenue> listOderRevenues= StatisticsRepository.getOrderRevenueEachMonths();
        ArrayList<Revenue> listServiceRevenues= StatisticsRepository.getServiceRevenueEachMonths();
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        System.out.println(  formatter.format(orderRevenue));
        ArrayList listFood=StatisticsRepository.getListRankOfFood();
        request.setAttribute("numberOfUsers", numberOfUsers);
        request.setAttribute("numberOfOrderToConfirm", numberOfOrderToConfirm);
        request.setAttribute("numberOfPetsLeft", numberOfPetsLeft);
        request.setAttribute("orderRevenue",   formatter.format(orderRevenue));
        request.setAttribute("listFood",listFood);
        request.setAttribute("serviceRevenue",formatter.format(serviceRevenue));
        request.setAttribute("listOderRevenues",listOderRevenues);
        request.setAttribute("listServiceRevenues",listServiceRevenues);
        request.getRequestDispatcher("statisticspage.jsp").forward(request,response);

        //request.setAttribute();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
