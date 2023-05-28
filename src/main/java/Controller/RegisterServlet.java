package Controller;

import Model.UserDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
//aloalo yy
@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.sendRedirect("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username=request.getParameter("username");
        String password = request.getParameter("password");
        String firstname=request.getParameter("firstname")
                , lastname=request.getParameter("lastname")
                ,address=request.getParameter("address")
                ,phone=request.getParameter("phone");
        //check exist username
        if(UserDAO.checkExistUsername(username)){
            request.setAttribute("thongbao","Tên đăng nhập đã tồn tại");
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
        else {
            String userID= MyRandom.getRandomCusID();

            System.out.println("Register "+ username +" " + password+" "+ firstname+ " "+lastname+" "+address+" "+phone);
            //insert table tblCustomer and tblAccount
            UserDAO.addCustomer(userID,firstname,lastname,address,phone,username,password);

            request.setAttribute("thongbao","Đăng kí thành công vui lòng đăng nhập vào hệ thống");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }


    }
}
