package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ManageSlotOfDayServlet", value = "/slotdetail")
public class ManageSlotOfDayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String day=request.getParameter("day");
        System.out.println(day);
    request.setAttribute("day",day);
    request.getRequestDispatcher("calendar-add.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
