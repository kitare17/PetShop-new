package controller;

import entity.Pet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ProductRepository;

import java.io.IOException;

@WebServlet(name = "UpdatePetServlet", value = "/updatepet")
public class UpdatePetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String petID=request.getParameter("petID");
    Pet pet= ProductRepository.getPet(petID);
    request.setAttribute("pet",pet);
    request.getRequestDispatcher("pet-update.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String productId, String productName, String productType,
//        double productPrice, int productAmount, ArrayList<
//        Image > listImg, int status
        String petID=request.getParameter("petID");
        String petName=request.getParameter("petName");
        double petPrice=Double.parseDouble(request.getParameter("petPrice")) ;
        String petType=request.getParameter("petType");
        int petStatus=Integer.parseInt(request.getParameter("status")) ;
        Pet pet =new Pet();
        pet.setProductId(petID);
        pet.setProductName(petName);
        pet.setProductPrice(petPrice);
        pet.setProductType(petType);
        pet.setStatus(petStatus);
        ProductRepository.updatePet(pet);
        request.setAttribute("pet",pet);
        request.setAttribute("thongbao","Cập nhật thành công");
        request.getRequestDispatcher("pet-update.jsp").forward(request,response);

    }
}
