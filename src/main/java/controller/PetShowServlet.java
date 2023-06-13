package controller;

import entity.Cart;
import entity.Items;
import entity.Pet;
import entity.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.ProductRepository;
import service.ProductService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "petShowServlet", value = "/pet")
public class PetShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String page = request.getParameter("page");
        if (page==null) page="1";
        ArrayList<Pet> listPet = ProductRepository.getListPetPage(page);
        double size=ProductRepository.getPetSize();
        int maxPage= (int) Math.ceil(size/9);
//        try {
//            String PetType = request.getParameter("type");
//            if (PetType.equals("all") || PetType.isEmpty()) {
//                listPet = ProductRepository.getListPet();
//            } else if (PetType.equals("dog")) {
//                listPet = ProductRepository.getListDog();
//            } else if (PetType.equals("cat")) {
//                listPet = ProductRepository.getListCat();
//
//            }
//        } catch (Exception e) {
//            listPet = ProductRepository.getListPet();
//
//        }

        request.setAttribute("listPet", listPet);
        request.setAttribute("maxPage", maxPage);
        request.getRequestDispatcher("pet.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
