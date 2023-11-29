package controller;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.OrderRepository;

import java.io.IOException;

@WebServlet(name = "AcceptOrderServlet", value = "/acceptorder")
public class AcceptOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getParameter("id");
        System.out.println(id);

        if(!OrderRepository.checkValidStatusOfPet(id) || !OrderRepository.checkValidAmountOfPet(id)){

            response.sendRedirect("order-list-manager?thongbao=0");
        }
        else{
            HttpSession session=request.getSession();
            User user=(User) session.getAttribute("user");
            OrderRepository.acceptOrder(id,user.getUserId());
            OrderRepository.acceptedPet(id);
            response.sendRedirect("order-list-manager?thongbao=1");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
