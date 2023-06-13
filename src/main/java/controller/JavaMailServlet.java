package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import service.MyRandom;
import service.SendMail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "JavaMailServlet", value = "/mailforgot")
public class JavaMailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mail = request.getParameter("mail");
        String otp = MyRandom.getRandomOTP();
        HttpSession session = request.getSession();
        session.setAttribute("otp", otp);
        session.setAttribute("mailForgot", mail);
        SendMail.forgotPass(mail, otp);
        response.sendRedirect("otp");
    }
}
