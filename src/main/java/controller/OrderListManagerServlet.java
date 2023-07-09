package controller;

import entity.OrderAccept;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import repository.OrderRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "OrderListManagerServlet", value = "/order-list-manager")
public class OrderListManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<OrderAccept> listOrder= OrderRepository.getAllOrder();
        String thongbao;
        try{
            if(!request.getParameter("thongbao").equals(null)){
                if(request.getParameter("thongbao").equals("1")){
                    thongbao="Xác nhận đơn hàng thành công";
                }
                else {
                    thongbao = "Đơn hàng không hợp lệ vui lòng hủy đơn hàng";
                }
                request.setAttribute("thongbao",thongbao);
            }
        }
        catch (Exception e){

        }

        request.setAttribute("listOrder",listOrder);

        request.getRequestDispatcher("order-list-manager.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
