package controller;

import entity.Account;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.UserRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageCusAccountServlet", value = "/manage-cus-account")
public class ManageCusAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Account> listCusAcc= UserRepository.getListCusAccount();
        request.setAttribute("listCusAcc",listCusAcc);
        request.getRequestDispatcher("managecustomeraccount.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
