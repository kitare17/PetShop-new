package controller;

import entity.Cart;
import entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.AuthenticationRepository;

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
        System.out.println(username+" "+password);
        User user=(User) AuthenticationRepository.Verify(username,password);
        System.out.println(user);

        if(user!=null){
               if(AuthenticationRepository.getStatusAcc(username)==0)

               {
                   request.setAttribute("thongbao", "Tài khoản hiện bị khóa vui lòng liên hệ với Admin");
                   request.getRequestDispatcher("login.jsp").forward(request, response);
               }else {
                   Cookie userCookies = new Cookie("username", username);
                   Cookie passCookies = new Cookie("password", password);
                   userCookies.setMaxAge(60 * 60 * 24);
                   passCookies.setMaxAge(60 * 60 * 24);
                   response.addCookie(userCookies);
                   response.addCookie(passCookies);
                   HttpSession session = request.getSession();
                   session.setAttribute("user", user);
                   session.setAttribute("cart", new Cart());
                   System.out.println("Đăng nhập thành công");
                   response.sendRedirect("index.jsp");
               }
        }
        else{
            request.setAttribute("thongbao", "Thông tin đăng nhập không chính xác");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
