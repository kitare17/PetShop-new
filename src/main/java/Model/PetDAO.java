package Model;


import Entity.Image;
import Entity.Pet;
import Entity.Product;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PetDAO {
    public static ArrayList<Image> getPetImgByID(String petID) {
        ArrayList<Image> listPetImg = new ArrayList<>();

        try {
            String query = "select * from tblPetImage where PetID=?";
            Connection con = PetShopDB.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            preSt.setString(1, petID);
            ResultSet rs = preSt.executeQuery();
            while (rs.next()) {
                String url = rs.getString(2);
                listPetImg.add(new Image(petID, url));

            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listPetImg;
    }


    public static ArrayList<Pet> getListPet(){
        ArrayList<Pet> listPet=new ArrayList<>();
        try{
            String query = "select * from  tblPet";
            Connection con = PetShopDB.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            ResultSet rs = preSt.executeQuery();
            while (rs.next()) {
                 String productID =rs.getString(1),
                        productName=rs.getString(2),
                        productType=rs.getString(3);
                 double productPrice=rs.getDouble(4);
                 String productStatus=rs.getString(5);
                 ArrayList<Image> lisPetImg=getPetImgByID(productID);
                Pet newPet = new Pet(productID,productName,productType,productPrice,productStatus);
                newPet.setListPetImage(lisPetImg);
                listPet.add(newPet);

            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listPet;
    }
    public static void main(String[] args) {
        //test getPetImgByID(String petID)
//        for (Image img : getPetImgByID("P0001")){
//                System.out.println(img);
//        }
        //test getListPet()
//        for (Pet pet :getListPet()){
//            System.out.println(pet);
//            for (Image img:pet.getListPetImage()){
//                System.out.println(img);
//            }
//        }

    }
}
