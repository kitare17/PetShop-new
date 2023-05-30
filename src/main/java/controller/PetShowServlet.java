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

        ArrayList<Pet> listPet=null;

        try {
            String PetType = request.getParameter("type");
            if (PetType.equals("all") || PetType.isEmpty()) {
                listPet = ProductService.listPet();
            } else if (PetType.equals("dog")) {
                listPet = ProductService.listDog();
            } else if (PetType.equals("cat")) {
                listPet = ProductService.listCat();

            }
        } catch (Exception e) {
            listPet = ProductService.listPet();

        }
        ArrayList<Pet> subListPet = new ArrayList<Pet>();
        int size = listPet.size();//get size
        int amountPet = 8;//amount on page
        int maxPage = (size % amountPet == 0) ? size / amountPet : size / amountPet + 1;
        int pageAmount = 5;
        int page;
        try {
            if (request.getParameter("page").equals("fisrt")) {
                page = 1;
            } else if (request.getParameter("page").equals("last")) {
                page = maxPage;
            } else {
                page = Integer.parseInt(request.getParameter("page"));
            }
        } catch (Exception e) {
            page = 1;
        }

        System.out.println(page + " " + size);

        int realAmountPet = (page * amountPet > size) ? size : page * amountPet;//set amount user if exceed real size
        System.out.println(realAmountPet);
        for (int i = page * amountPet - amountPet; i < realAmountPet; i++) {
            subListPet.add(listPet.get(i));
            System.out.println(i);
        }
        request.setAttribute("listPet", subListPet);

        request.setAttribute("page", page);
        request.setAttribute("maxPage", maxPage);
        request.getRequestDispatcher("pet.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
