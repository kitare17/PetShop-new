package controller;

import entity.Pet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.AdminRepository;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UpdatePetServlet", value = "/updatepet")
public class UpdatePetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = request.getParameter("id");
//        String name = request.getParameter("name");
//        String type = request.getParameter("type");
//        double price = Double.parseDouble(request.getParameter("price"));
//        int amount = Integer.parseInt(request.getParameter("amount"));
//        String color = request.getParameter("color");
//        Pet pet = new Pet(id, name, type, price, amount,);
//        System.out.println(pet);
//        AdminRepository.updatePet(pet);
//        response.sendRedirect("admin.jsp");

    }
}
