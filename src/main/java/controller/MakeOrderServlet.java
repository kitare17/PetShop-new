package controller;

import entity.Cart;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.AdminRepository;
import repository.OrderRepository;

import java.io.IOException;

@WebServlet(name = "makeOrderServlet", value = "/makeoder")
public class MakeOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Cart cart = (Cart) session.getAttribute("cart");
        String orderId = OrderRepository.createOrder(cart,user);
        cart.removeAll();
        request.getRequestDispatcher("getordereddetail?orderId="+orderId).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
