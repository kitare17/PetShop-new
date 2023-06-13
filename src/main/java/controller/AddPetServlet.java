package controller;

import entity.Image;
import entity.Pet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.ProductRepository;
import service.MyRandom;

import java.io.IOException;
import java.util.ArrayList;
/*
CHUA PHAT TRIEN :D
 */
@WebServlet(name = "AddPetServlet", value = "/addpet")
public class AddPetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //String productId, String productName, String productType, double productPrice
        // , int productAmount, ArrayList<Image> listImg, int status
        String petID= MyRandom.getRandomPetID();
        String petName=request.getParameter("petName");
        double petPrice=0  ;
        if( !request.getParameter("petPrice").isEmpty())  petPrice=Double.parseDouble( request.getParameter("petPrice"))  ;
        String petType=request.getParameter("petType");
        String petUrlImg=request.getParameter("petUrlImg");
        System.out.println("Them " +petID +" "+ petName+" "+ petPrice+" "+ petType+" "+petUrlImg );
       ArrayList<Image> listImg=new ArrayList<Image>();
       listImg.add(new Image(petID,petUrlImg));
      Pet pet =new Pet(petID,petName,petType,petPrice,1,listImg,1);
        ProductRepository.addPet(pet);
      request.setAttribute("thongbao","Thêm thành công");
      request.getRequestDispatcher("pet-add.jsp").forward(request,response);

    }
}
