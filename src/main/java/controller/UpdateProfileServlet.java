package controller;

import entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.UserRepository;

import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/updateprofile")
public class UpdateProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("profile");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname=request.getParameter("firstname")
                , lastname=request.getParameter("lastname")
                ,address=request.getParameter("address")
                ,phone=request.getParameter("phone");
        System.out.println( firstname+ " "+lastname+" "+address+" "+phone);
        HttpSession session=request.getSession();
        User oldUser=(User)session.getAttribute("user");
        String userID=oldUser.getUserId();
        //update user in session
        oldUser.setFirstname(firstname);
        oldUser.setLastname(lastname);
        oldUser.setAddress(address);
        oldUser.setPhone(phone);
        session.setAttribute("user",oldUser);
        //Update in database
        UserRepository.updateUser(userID,firstname,lastname,address,phone);

        doGet(request,response);

    }
}
