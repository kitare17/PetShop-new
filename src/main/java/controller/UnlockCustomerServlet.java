package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.UserRepository;

import java.io.IOException;

@WebServlet(name = "UnlockCustomerServlet", value = "/unlockcustomer")
public class UnlockCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empID=request.getParameter("empID");
        UserRepository.unlockCustomer(empID);
        response.sendRedirect("manage-cus-account");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
