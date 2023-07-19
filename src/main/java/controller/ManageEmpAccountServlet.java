package controller;

import entity.Account;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.UserRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageAccountServlet", value = "/manage-emp-account")
public class ManageEmpAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Account> listEmpAcc= UserRepository.getListEmpAccount();
        request.setAttribute("listEmpAcc",listEmpAcc);
        request.getRequestDispatcher("manageemployeeaccount.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
