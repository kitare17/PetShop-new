package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ServiceRespository;

import java.io.IOException;

@WebServlet(name = "CancelServiceBill", value = "/cancelservicebill")
public class CancelServiceBill extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String billID = request.getParameter("billID");
        ServiceRespository.cancelBill(billID);
        response.sendRedirect("getserviceorder");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
