package controller;

import entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ChangePassServlet", value = "/changepass")
public class ChangePassServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldPass = request.getParameter("oldPassword");
        String newPass = request.getParameter("password");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String userID = user.getUserId();
        System.out.println(oldPass + " " + newPass + " " + userID);
    }
}
