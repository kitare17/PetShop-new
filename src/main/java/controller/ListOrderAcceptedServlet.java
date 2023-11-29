package controller;

import entity.OrderAccept;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.OrderRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListOrderAcceptedServlet", value = "/list-order-accepted")
public class ListOrderAcceptedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<OrderAccept> listOrder = OrderRepository.getAllOrderAccepted();


        request.setAttribute("listOrder",listOrder);
        request.getRequestDispatcher("order-list-accepted.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
