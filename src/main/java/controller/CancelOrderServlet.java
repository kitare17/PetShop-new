package controller;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.OrderRepository;

import java.io.IOException;

@WebServlet(name = "RemoveOrderServlet", value = "/cancelorder")
public class CancelOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id");
        System.out.println(id);
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");
        OrderRepository.cancelOrder(id,user.getUserId());
        response.sendRedirect("order-list-manager");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
