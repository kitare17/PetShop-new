package controller;

import entity.OrderAccept;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.OrderRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "OrderListManagerServlet", value = "/order-list-manager")
public class OrderListManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<OrderAccept> listOrder= OrderRepository.getAllOrder();
        request.setAttribute("listOrder",listOrder);

        request.getRequestDispatcher("order-list-manager.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
