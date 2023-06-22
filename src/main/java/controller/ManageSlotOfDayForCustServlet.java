package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ServiceRespository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageSlotOfDayForCustServlet", value = "/slotdetailforcust")
public class ManageSlotOfDayForCustServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String day=request.getParameter("day");
    String serviceID=request.getParameter("serviceID");
    String serviceName=ServiceRespository.getServiceName(serviceID);
    ArrayList listShift= ServiceRespository.getAllShiftByDay(serviceID,day);
    request.setAttribute("listShift",listShift);
    request.setAttribute("day",day);
    request.setAttribute("serviceName",serviceName);
    request.setAttribute("serviceID",serviceID);
    request.getRequestDispatcher("calendar-booking.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
