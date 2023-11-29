package controller;

import entity.Product;
import entity.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ProductRepository;

import java.io.IOException;

@WebServlet(name = "getServiceDetailServlet", value = "/getservicedetail")
public class GetServiceDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("serviceID");
        if (id == null) {
            response.sendRedirect("index.jsp");
        } else {
            System.out.println("===============>");
            System.out.println("===============> " + id);
            Service s = ProductRepository.getService(id);
            request.setAttribute("service", s);
            request.getRequestDispatcher("service-detail.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
