package controller;

import entity.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.AdminRepository;

import java.io.IOException;

@WebServlet(name = "changeAmmountServlet", value = "/changeammount")
public class ChangeAmmountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        String increase = request.getParameter("increase");
        String decrease = request.getParameter("decrease");
        String delete = request.getParameter("delete");
        if (increase != null) {
            System.out.println(cart.increaseAmmount(increase));
        } else if (decrease != null) {
            System.out.println(cart.decreaseAmmount(decrease));
        } else if (delete != null) {
            System.out.println(cart.removeItem(delete));
        }
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
