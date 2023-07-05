package controller;

import entity.ServiceBill;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ServiceRespository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetServiceOrderServlet", value = "/getserviceorder")
public class GetServiceOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<ServiceBill>  listServiceOrder= ServiceRespository.getAllServiceOrder();
        request.setAttribute("listServiceOrder",listServiceOrder);
        request.getRequestDispatcher("serviceorder.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
