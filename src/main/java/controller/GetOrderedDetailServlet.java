package controller;

import entity.Cart;
import entity.Items;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.OrderRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetOrderedDetail", value = "/getordereddetail")
public class GetOrderedDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        Cart orderedCart = new Cart();
        ArrayList<Items> ordered = OrderRepository.getOrder(orderId);
        String orderStatus = OrderRepository.getOrderStatus(orderId);
        orderedCart.setCart(ordered);
        request.setAttribute("orderId", orderId);
        request.setAttribute("orderStatus", orderStatus);
        request.setAttribute("orderedCart", orderedCart);
        request.getRequestDispatcher("ordered.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
