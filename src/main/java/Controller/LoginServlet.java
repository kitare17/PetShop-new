package Controller;

import Entity.User;
import Model.AuthenticationDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User user= AuthenticationDAO.Verify(username,password);
        System.out.println(user);
        if(user!=null){
            Cookie userCookies=new Cookie("username", username);
            Cookie passCookies=new Cookie("password", password);
            userCookies.setMaxAge(60*60*24);
            passCookies.setMaxAge(60*60*24);
            response.addCookie(userCookies);
            response.addCookie(passCookies);
            HttpSession session=request.getSession();
            session.setAttribute("user", user);
            //session.setAttribute("cart", new Cart());
            response.sendRedirect("index.jsp");

        }
        else{
            request.setAttribute("thongbao", "Thông tin đăng nhập không chính xác");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
