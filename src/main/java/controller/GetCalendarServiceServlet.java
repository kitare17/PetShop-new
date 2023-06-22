package controller;

import entity.Calendar;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ServiceRespository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet(name = "GetCalendarServiceServlet", value = "/manage-calendar-service")
public class GetCalendarServiceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String serviceID =request.getParameter("serviceID");
  String serviceName=ServiceRespository.getServiceName(serviceID);
        LocalDate today=LocalDate.now();
       int month=today.getMonthValue();
       int year=today.getYear();
       String date=today.getYear()+"-"+((today.getMonthValue()>=10)?today.getMonthValue():"0"+""+today.getMonthValue())+"-"
               +(today.getDayOfMonth()>=10?today.getDayOfMonth():"0"+""+today.getDayOfMonth());
        ArrayList<Calendar> listCalendar= ServiceRespository.getCalendarByMonthYear(serviceID,month,year);

        request.setAttribute("listCalendar",listCalendar);
        request.setAttribute("date",date);
        request.setAttribute("serviceID",serviceID);
        request.setAttribute("serviceName",serviceName);
        request.getRequestDispatcher("manage-calendar-service.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
