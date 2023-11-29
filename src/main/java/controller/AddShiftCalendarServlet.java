package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ServiceRespository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@WebServlet(name = "AddShiftCalendarServlet", value = "/addshiftcalendar")
public class AddShiftCalendarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String shiftID = request.getParameter("shiftID");
        String serviceID = request.getParameter("serviceID");
        String day = request.getParameter("day");

        String thongbao;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate homNay = LocalDate.now();//Lấy thời gian hôm nay
        String homNayS = homNay.format(formatter);
        String ngayDat = day;// setDay đấy
        LocalDate ngayDatF = LocalDate.parse(ngayDat, formatter);

        long daysBetween = ChronoUnit.DAYS.between( homNay,ngayDatF);


        //kiểm tra điều kiện
        if (daysBetween >= 2) {
            System.out.println("ok");


            request.setAttribute("shiftID",shiftID);
            request.setAttribute("serviceID",serviceID);
            request.setAttribute("day",day);
            request.getRequestDispatcher("addshiftcalendar.jsp").forward(request,response);
        } else {
            thongbao="Ngày đặt: ("+ngayDat + ") và Hôm nay (" + homNayS + ") phải cách nhau 2 ngày";
            request.setAttribute("thongbao",thongbao);
            request.getRequestDispatcher("slotdetail?day="+day+"&serviceID="+serviceID).forward(request,response);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String shiftID =request.getParameter("shiftID");
      String serviceID=request.getParameter("serviceID");
      String numberOfResponses=request.getParameter("numberOfResponses");
      String setDay=request.getParameter("setDay");
        ServiceRespository.addShiftCalendar(shiftID,serviceID,numberOfResponses,setDay);
    response.sendRedirect("slotdetail?day="+setDay+"&serviceID="+serviceID);
    }
}
