package controller;

import entity.Cart;
import entity.Items;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.ProductRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddItemServlet", value = "/additem")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        if(session.getAttribute("user")==null) {
            request.setAttribute("thongbao", "Vui lòng đăng nhập để sử dụng dịch vụ");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        try {
            String id = request.getParameter("id");
            String ammout = request.getParameter("ammount");
            Product p = null;
            if (id.contains("P")) {
                p = ProductRepository.getPet(id);
            } else if (id.contains("F")) {
                p = ProductRepository.getFood(id);

            } else {
                System.out.println("=============>Loi if else check matching <===============");
            }
            Cart cart = (Cart) session.getAttribute("cart");
            boolean checkPet=true;
            for (Items item: cart.getCart()
                 ) {
             if(item.getProduct().getProductId().startsWith("P")){
                 if(item.getProduct().getProductId().equals(id)) checkPet=false;
             }

            }
            Items item = new Items(p, Integer.parseInt(ammout));
            if(checkPet){
                System.out.println(cart.addItems(item));
                System.out.println(cart);
                request.setAttribute("product", p);
                request.setAttribute("message", "Thêm sản phẩm thành công");
                response.setCharacterEncoding("UTF-8");
                session.setAttribute("cart", cart);
                request.getRequestDispatcher("product-detail.jsp").forward(request, response);

            }else
            {
                request.setAttribute("product", p);
                request.setAttribute("message", "Thú cưng này đã có trong giỏ hàng");
                response.setCharacterEncoding("UTF-8");

                request.getRequestDispatcher("product-detail.jsp").forward(request, response);
            }



        } catch (Exception e) {
            System.out.println("=============>Loi AdditemServlet <===============");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
