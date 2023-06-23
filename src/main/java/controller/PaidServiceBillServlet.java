package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ServiceRespository;

import java.io.IOException;

@WebServlet(name = "PaidServiceBillServlet", value = "/paidserivebill")
public class PaidServiceBillServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String billID = request.getParameter("billID");
        ServiceRespository.paidBill(billID);
        response.sendRedirect("getserviceacceptedorder");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
