package controller;

import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.AdminRepository;
import repository.ProductRepository;

import java.io.IOException;

@WebServlet(name = "getPetDetailServlet", value = "/getpetdetail")
public class GetPetDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("id");
//        if (id == null) {
//            System.out.println("null");
//        } else {
//            Product p = ProductRepository.getPet(id);
//            System.out.println(p);
//            request.setAttribute("product", p);
//            request.getRequestDispatcher("product-detail.jsp").forward(request, response);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
