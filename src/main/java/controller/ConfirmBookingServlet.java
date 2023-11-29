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

import java.io.IOException;

@WebServlet(name = "ConfirmBookingServlet", value = "/confirmbooking")
public class ConfirmBookingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Serviceid= request.getParameter("ServiceID");
        String setDay= request.getParameter("day");
        String shiftID= request.getParameter("shiftID");
        int handleNum = ServiceRespository.getHandleNumberOfSlot(Serviceid,shiftID,setDay);
        int bookedNum = ServiceRespository.getBookedNumberOfSlot(Serviceid,shiftID,setDay);
        Service s = ProductRepository.getService(Serviceid);
        int max = handleNum - bookedNum;
        request.setAttribute("ServiceID",Serviceid );
        request.setAttribute("setDay",setDay );
        request.setAttribute("shiftID",shiftID );
        request.setAttribute("handleNum",handleNum );
        request.setAttribute("bookedNum",bookedNum );
        request.setAttribute("servicePrice", s.getServicePrice());
        request.setAttribute("max",max);

//        System.out.println(id);
//        HttpSession session=request.getSession();
//        User user=(User) session.getAttribute("user");
//        OrderRepository.acceptOrder(id,user.getUserId());
//        ${serviceID}&day=${day}&shiftID={l.shiftID}"
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
