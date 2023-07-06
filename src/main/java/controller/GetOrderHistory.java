package controller;

import entity.Cart;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.OrderRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetOrderHistory", value = "/getorderhistory")
public class GetOrderHistory extends HttpServlet {
//    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String userId = user.getUserId();
        ArrayList<String> listOrderId = OrderRepository.getOrderIdList(userId); //danh sach id cua cac order
        ArrayList<Cart> listOrdered = new ArrayList<>(); //list cac don hang da dat(cart)
        for (String orderId : listOrderId) {
            Cart orderedCart = new Cart();
            orderedCart.setCart(OrderRepository.getOrder(orderId));
            orderedCart.setOrderedId(orderId);
            orderedCart.setOrderStatus(OrderRepository.getOrderStatus(orderId));
            orderedCart.setDate(OrderRepository.getOrderDate(orderId));
            orderedCart.setDiscountCode(OrderRepository.getDiscountCodeByOrderID(orderId));
            orderedCart.setDiscountPercent(OrderRepository.getDiscountPercent(orderedCart.getDiscountCode()));
            listOrdered.add(orderedCart);
        }
        request.setAttribute("listOrdered", listOrdered);
        request.getRequestDispatcher("orderhistory.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
