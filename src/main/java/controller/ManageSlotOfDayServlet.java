package controller;

import entity.Shift;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ServiceRespository;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet(name = "ManageSlotOfDayServlet", value = "/slotdetail")
public class ManageSlotOfDayServlet extends HttpServlet {
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
    request.getRequestDispatcher("calendar-add.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
