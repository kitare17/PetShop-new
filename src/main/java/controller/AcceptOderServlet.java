package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.AdminRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AcceptOrderServlet", value = "/acceptorder")
public class AcceptOderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id= request.getParameter("id");
//        System.out.println(id);
//        AdminRepository.acceptOrder(id);
//        response.sendRedirect("admin.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}