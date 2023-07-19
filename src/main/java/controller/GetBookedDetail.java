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

@WebServlet(name = "GetBookedDetail", value = "/getbookeddetail")
public class GetBookedDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String billID = request.getParameter("billID");
        String serviceName = request.getParameter("serviceName");
        String ammount = request.getParameter("ammount");
        String status = request.getParameter("status");
        String priceAtPurchase = request.getParameter("priceAtPurchase");

        request.setAttribute("billID", billID);
        request.setAttribute("serviceName", serviceName);
        request.setAttribute("ammount", ammount);
        request.setAttribute("status", status);
        request.setAttribute("priceAtPurchase", priceAtPurchase);

        request.getRequestDispatcher("booked-detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
