package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.ServiceRespository;

import java.io.IOException;

@WebServlet(name = "AcceptServiceBillServlet", value = "/acceptservicebill")
public class AcceptServiceBillServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String thongbao="";
        String billID = request.getParameter("billID");
        String serviceID=request.getParameter("serviceID");
        String shiftID=request.getParameter("shiftID");
        String setDay=request.getParameter("setDay");
        int numberOfPetRequest=0;
        try{
             numberOfPetRequest=Integer.parseInt(request.getParameter("numberOfPet"));

        }
        catch (Exception e){
            e.printStackTrace();
        }

        int numberOfBooked=ServiceRespository.getBookedNumberOfSlot(serviceID,shiftID,setDay);
        int numberOfSlot=ServiceRespository.getHandleNumberOfSlot(serviceID,shiftID,setDay);
        if(numberOfSlot-numberOfBooked-numberOfPetRequest>=0){
            ServiceRespository.acceptBill(billID);
            thongbao=thongbao.concat("Xác nhận thành công");
            System.out.println(thongbao+" alo");

        }else {
          thongbao=  thongbao.concat("Xác nhận thất bại quá vì số lượng yêu cầu vui lòng kiểm tra lại");
            System.out.println(thongbao+" alo");
        }
        request.setAttribute("thongbao",thongbao);
        request.getRequestDispatcher("getserviceorder").forward(request,response);
       // response.sendRedirect("getserviceorder?thongbao="+thongbao);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
