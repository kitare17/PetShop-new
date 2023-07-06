package controller;

import entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.UserRepository;

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
        int thongbao2=1;

       if(UserRepository.checkOldPass(userID,oldPass))
           UserRepository.changePass(userID, newPass);
       else
          thongbao2=0;
        System.out.println("thongbao2 ne"+thongbao2);

      response.sendRedirect("profile?thongbao2="+thongbao2);
    }
}
