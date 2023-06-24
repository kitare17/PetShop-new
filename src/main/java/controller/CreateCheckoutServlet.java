package controller;

import entity.Service;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.OrderRepository;
import repository.ProductRepository;
import repository.ServiceRespository;
import service.MyRandom;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@WebServlet(name = "CreateCheckoutServlet", value = "/createcheckout")
public class CreateCheckoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");
        String serviceid= request.getParameter("ServiceID");
        String setDay= request.getParameter("setDay");
        String shiftID= request.getParameter("shiftID");
        int  ammount =Integer.parseInt(request.getParameter("ammount")) ;
        String userId = user.getUserId();
        String billID = MyRandom.getRandomServiceBillID();
        String thongbao;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate homNay = LocalDate.now();//Lấy thời gian hôm nay
        String homNayS = homNay.format(formatter);
        LocalDate ngayDatF = LocalDate.parse(setDay, formatter);
        long daysBetween = ChronoUnit.DAYS.between( homNay,ngayDatF);
        if (daysBetween >= 2) {
            ServiceRespository.createCheckout(billID,userId,homNayS,serviceid,shiftID,setDay,ammount);
            request.getRequestDispatcher("checkout.jsp").forward(request,response);

        } else {
            thongbao="Ngày đặt: ("+setDay + ") và Hôm nay (" + homNayS + ") phải cách nhau 2 ngày";
            System.out.println(thongbao);
            request.getRequestDispatcher("checkout.jsp").forward(request,response);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ddddddddddddddddddddddddddddddddddddddddddddit me ");
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");
        String serviceid= request.getParameter("ServiceID");
        String setDay= request.getParameter("setDay");
        String shiftID= request.getParameter("shiftID");
        int  ammount =Integer.parseInt(request.getParameter("ammount")) ;
        String userId = user.getUserId();
        String billID = MyRandom.getRandomServiceBillID();
        String thongbao;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate homNay = LocalDate.now();//Lấy thời gian hôm nay
        String homNayS = homNay.format(formatter);
        LocalDate ngayDatF = LocalDate.parse(setDay, formatter);
        long daysBetween = ChronoUnit.DAYS.between( homNay,ngayDatF);
        if (daysBetween >= 2) {
            thongbao = "đặt thành công";
            request.setAttribute("thongbao",thongbao);
            ServiceRespository.createCheckout(billID,userId,homNayS,serviceid,shiftID,setDay,ammount);
            request.getRequestDispatcher("checkout.jsp").forward(request,response);

        } else {
            thongbao="Ngày đặt: ("+setDay + ") và Hôm nay (" + homNayS + ") phải cách nhau 2 ngày";
            request.setAttribute("thongbao",thongbao);
            System.out.println(thongbao);
            request.getRequestDispatcher("checkout.jsp").forward(request,response);
        }



    }
}
