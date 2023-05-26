package Controller;

import Entity.Food;
import Entity.Pet;
import Model.FoodDAO;
import Model.PetDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PetServlet", value = "/pet")
public class PetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Pet> listPet= PetDAO.getListPet();
        request.setAttribute("listPet",listPet);
        request.getRequestDispatcher("pet.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
