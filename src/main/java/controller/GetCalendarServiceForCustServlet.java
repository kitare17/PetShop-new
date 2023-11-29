package controller;

import entity.Calendar;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.OrderRepository;
import repository.ServiceRespository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet(name = "GetCalendarServiceForCustServlet", value = "/get-calendar-service")
public class GetCalendarServiceForCustServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String serviceID =request.getParameter("serviceID");
        LocalDate today=LocalDate.now();
        int month=today.getMonthValue();
        int year=today.getYear();
        String date=today.getYear()+"-"+((today.getMonthValue()>=10)?today.getMonthValue():"0"+""+today.getMonthValue())+"-"
                +(today.getDayOfMonth()>=10?today.getDayOfMonth():"0"+""+today.getDayOfMonth());
        ArrayList<Calendar> listCalendar= ServiceRespository.getCalendarByMonthYear(serviceID,month,year);
//        System.out.println(listCalendar.get(0));
        String serviceName=ServiceRespository.getServiceName(serviceID);
        request.setAttribute("serviceName",serviceName);
        request.setAttribute("listCalendar",listCalendar);
        request.setAttribute("date",date);
        request.setAttribute("serviceID",serviceID);
        request.getRequestDispatcher("calendar-service.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
