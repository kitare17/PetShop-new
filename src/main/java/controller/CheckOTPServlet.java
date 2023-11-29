package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.AuthenticationRepository;

import java.io.IOException;

@WebServlet(name = "CheckOTPServlet", value = "/otp")
public class CheckOTPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   response.sendRedirect("otp.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String inputOTP= request.getParameter("otp");
    HttpSession session =request.getSession();
    String otp= (String) session.getAttribute("otp");
    String email=(String)session.getAttribute("mailForgot");

    if(otp.equals(inputOTP)){
        String username= AuthenticationRepository.getUsernameByEmail(email);
         session.setAttribute("username",username);
        response.sendRedirect("resetpass.jsp");}
    else {
        request.setAttribute("thongbao","Mã otp không chính xác");
        request.getRequestDispatcher("otp.jsp").forward(request,response);
    }
    }
}
