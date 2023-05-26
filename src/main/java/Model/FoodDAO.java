package Model;

import Entity.Food;
import Entity.Image;
import Entity.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FoodDAO {
    public static ArrayList<Image> getFoodImgByID(String FoodID) {
        ArrayList<Image> listFoodImg = new ArrayList<>();

        try {
            String query = "select * from tblFoodImage where FoodID=?";
            Connection con = PetShopDB.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            preSt.setString(1, FoodID);
            ResultSet rs = preSt.executeQuery();
            while (rs.next()) {
                String url = rs.getString(2);
                listFoodImg.add(new Image(FoodID, url));

            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listFoodImg;
    }


    public static ArrayList<Food> getListFood(){
        ArrayList<Food> listFood=new ArrayList<>();
        try{
            String query = "select * from  tblFood";
            Connection con = PetShopDB.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            ResultSet rs = preSt.executeQuery();
            while (rs.next()) {
                String productID =rs.getString(1),
                        productName=rs.getString(2),
                        productType=rs.getString(3),
                       origin=rs.getString(4);
                double productPrice=rs.getDouble(5);
                String productStatus=rs.getString(6);
                ArrayList<Image> lisPetImg=getFoodImgByID(productID);
                Food newFood = new Food( productID,  productName,  productType,  origin,  productPrice,  productStatus);
                newFood.setListFoodImage(lisPetImg);
                listFood.add(newFood);

            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listFood;
    }
    public static void main(String[] args) {
        //test getPetImgByID(String petID)
//        for (Image img : getFoodImgByID("F0001")){
//                System.out.println(img);
//        }
        //test getListFood()
        for (Food food :getListFood()){
            System.out.println(food);
            for (Image img:food.getListFoodImage()){
                System.out.println(img);
            }
        }

    }
}
