package controller;

import entity.Cart;
import entity.Items;
import entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.OrderRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetOrderedDetailForEmpServlet", value = "/getordereddetailemp")
public class GetOrderedDetailForEmpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        Cart orderedCart = new Cart();
        ArrayList<Items> ordered = OrderRepository.getOrder(orderId);
        String orderStatus = OrderRepository.getOrderStatus(orderId);
        orderedCart.setCart(ordered);
        orderedCart.setOrderedId(orderId);
        orderedCart.setDiscountCode(OrderRepository.getDiscountCodeByOrderID(orderId));
        orderedCart.setDiscountPercent(OrderRepository.getDiscountPercent(orderedCart.getDiscountCode()));
        System.out.println("mã giam của đơn đã đặt  " + orderedCart.getDiscountCode());
        request.setAttribute("orderId", orderId);
        request.setAttribute("orderStatus", orderStatus);
        request.setAttribute("orderedCart", orderedCart);
        User user =OrderRepository.getCustomerByBillID(orderId);
        request.setAttribute("user",user);

        request.getRequestDispatcher("history_order_for_emp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
