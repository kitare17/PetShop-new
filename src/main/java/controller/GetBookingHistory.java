package controller;

import entity.Cart;
import entity.ServiceBooked;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.OrderRepository;
import repository.ServiceRespository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@WebServlet(name = "GetBookingHistory", value = "/getbookinghistory")
public class GetBookingHistory extends HttpServlet {
//    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String userId = user.getUserId();
        ArrayList<ServiceBooked> listBooked = ServiceRespository.getBookingHistory(userId); //danh sach id cua cac order
//        Collections.sort(listOrdered, new Comparator<Cart>() {
//
//            @Override
//            public int compare(Cart o1, Cart o2) {
//                String dateString1 = o1.getDate();
//                String dateString2 = o2.getDate();
//
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                LocalDate localDate1 = LocalDate.parse(dateString1, formatter);
//                LocalDate localDate2 = LocalDate.parse(dateString2, formatter);
//                return  (-1)*localDate1.compareTo(localDate2);
//
//
//            }
//
//        });


        request.setAttribute("listOrdered", listBooked);
        request.getRequestDispatcher("bookinghistory.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
