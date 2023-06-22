package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddShiftCalendarServlet", value = "/addshiftcalendar")
public class AddShiftCalendarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shiftID = request.getParameter("shiftID");
        String serviceID = request.getParameter("serviceID");
        String day = request.getParameter("day");

        request.setAttribute("shiftID",shiftID);
        request.setAttribute("serviceID",serviceID);
        request.setAttribute("day",day);
        request.getRequestDispatcher("addshiftcalendar.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
