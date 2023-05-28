package Controller;

import Model.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID= MyRandom.getRandomCusID();
        String username=request.getParameter("username");
        String password = request.getParameter("password");
        String firstname=request.getParameter("firstname")
                , lastname=request.getParameter("lastname")
                ,address=request.getParameter("address")
                ,phone=request.getParameter("phone");
        System.out.println("Register "+ username +" " + password+" "+ firstname+ " "+lastname+" "+address+" "+phone);
        //check exist username


        //insert table tblCustomer and tblAccount
        UserDAO.addEmployee(userID,firstname,lastname,address,phone,username,password);
        request.setAttribute("thongbao","Đăng kí thành công vui lòng đăng nhập vào hệ thống");
        request.getRequestDispatcher("login").forward(request,response);
    }
}
