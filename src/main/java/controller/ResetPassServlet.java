package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.AuthenticationRepository;

import java.io.IOException;

@WebServlet(name = "ResetPassServlet", value = "/reset-pass")
public class ResetPassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String pass=request.getParameter("newpass");
        AuthenticationRepository.resetPass(username,pass);
        response.sendRedirect("login.jsp");
    }
}
