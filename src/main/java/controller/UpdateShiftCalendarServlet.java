package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ServiceRespository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@WebServlet(name = "UpdateShiftCalendarServlet", value = "/updateshiftcalendar")
public class UpdateShiftCalendarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shiftID = request.getParameter("shiftID");
        String serviceID = request.getParameter("serviceID");
        String day = request.getParameter("day");
        int numberOfResponses=0;
        if (request.getParameter("numberOfResponses")!=null)
            numberOfResponses=Integer.parseInt( request.getParameter("numberOfResponses"));

        String thongbao;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate homNay = LocalDate.now();//Lấy thời gian hôm nay
        String homNayS = homNay.format(formatter);
        String ngayDat = day;// setDay đấy
        LocalDate ngayDatF = LocalDate.parse(ngayDat, formatter);

        long daysBetween = ChronoUnit.DAYS.between( homNay,ngayDatF);
        if (daysBetween >= 2) {

            request.setAttribute("shiftID",shiftID);
            request.setAttribute("serviceID",serviceID);
            request.setAttribute("day",day);
            request.setAttribute("numberOfResponses",numberOfResponses);
            request.getRequestDispatcher("updateshiftcalendar.jsp").forward(request,response);
        } else {
            thongbao="Ngày đặt: ("+ngayDat + ") và Hôm nay (" + homNayS + ") phải cách nhau 2 ngày bạn không thể cập nhật";
            request.setAttribute("thongbao",thongbao);
            request.getRequestDispatcher("slotdetail?day="+day+"&serviceID="+serviceID).forward(request,response);
        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shiftID = request.getParameter("shiftID");
        String serviceID = request.getParameter("serviceID");
        String setDay = request.getParameter("setDay");
        int numberOfResponses=0;
        if (request.getParameter("numberOfResponses")!=null)
            numberOfResponses=Integer.parseInt( request.getParameter("numberOfResponses"));
        ServiceRespository.updateShiftCalendar(shiftID,serviceID,numberOfResponses,setDay);
        response.sendRedirect("slotdetail?day="+setDay+"&serviceID="+serviceID);
    }
}
