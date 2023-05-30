package repository;
import config.DBConnect;
import entity.Food;
import entity.Image;
import entity.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class ProductRepository {
    public static ArrayList<Image> getListPetImage(String petID){
        ArrayList<Image> images=new ArrayList<>();
        try {
            String query = "select * from tblPetImage where PetID =?";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,petID);
            ResultSet results = stmt.executeQuery();

            while (results.next()) {
                String url=results.getString(2);
                Image img=new Image(petID,url);
                images.add(img);
            }
        } catch (Exception e) {
            System.err.println("Loi database method getListPetImage class ProductRepository");
        }
        return images;
    }
    public static ArrayList<Image> getListFoodImage(String foodID){
        ArrayList<Image> images=new ArrayList<>();
        try {
            String query = "select * from tblFoodImage where FoodID =?";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,foodID);
            ResultSet results = stmt.executeQuery();

            while (results.next()) {
                String url=results.getString(2);
                Image img=new Image(foodID,url);
                images.add(img);
            }
        } catch (Exception e) {
            System.err.println("Loi database method getListFoodImage class ProductRepository");
        }
        return images;
    }
    public static ArrayList<Pet> getListPet() {
        ArrayList<Pet> listPet = new ArrayList<Pet>();
        try {
            String query = "select * from tblPet";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                String productId = results.getString(1);
                String productName = results.getString(2);
                String productType = results.getString(3);
                double productPrice = results.getDouble(4);
                int productAmount = 1;
                int productStatus=results.getInt(5);
                ArrayList<Image> images=getListPetImage(productId);
                
                Pet pet = new Pet(productId,productName,productType,productPrice,productAmount,images,productStatus);
                listPet.add(pet);
            }
        } catch (Exception e) {
            System.err.println("Loi database method listPet class ProductRepository");
        }
        return listPet;
    }

    public static ArrayList<Pet> getListCat(){
        ArrayList<Pet> listPet = new ArrayList<Pet>();
        try {
            String query = "select * from tblPet where PetType='cat'";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                String productId = results.getString(1);
                String productName = results.getString(2);
                String productType = results.getString(3);
                double productPrice = results.getDouble(4);
                int productAmount = 1;
                int productStatus=results.getInt(5);
                ArrayList<Image> images=getListPetImage(productId);

                Pet pet = new Pet(productId,productName,productType,productPrice,productAmount,images,productStatus);
                listPet.add(pet);
            }
        } catch (Exception e) {
            System.err.println("Loi database method getListCat class ProductRepository");
        }
        return listPet;
    }
    public static ArrayList<Pet> getListDog(){
        ArrayList<Pet> listPet = new ArrayList<Pet>();
        try {
            String query = "select * from tblPet where PetType='dog'";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                String productId = results.getString(1);
                String productName = results.getString(2);
                String productType = results.getString(3);
                double productPrice = results.getDouble(4);
                int productAmount = 1;
                int productStatus=results.getInt(5);
                ArrayList<Image> images=getListPetImage(productId);

                Pet pet = new Pet(productId,productName,productType,productPrice,productAmount,images,productStatus);
                listPet.add(pet);
            }
        } catch (Exception e) {
            System.err.println("Loi database method getListCat class ProductRepository");
        }
        return listPet;
    }
    // TODO: 5/30/2023  them tru so luong da ban trong bill
    public static int getFoodAmount(String FoodID){
        int amount=0;
        try {
            String query = "select sum(Amount) from tblImported where FoodID=?";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,FoodID);
            ResultSet results = stmt.executeQuery();

            while (results.next()) {
               amount=results.getInt(1);
            }
        } catch (Exception e) {
            System.err.println("Loi database method getFoodAmount class ProductRepository");
        }
        return amount;
    }
    public static ArrayList<Food> getListFood() {
        ArrayList<Food> listFood = new ArrayList<Food>();
        try {
            String query = "select * from tblFood";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                String productId = results.getString(1);
                String productName = results.getString(2);
                String productType = results.getString(3);
                String origin=results.getString(4);
                double productPrice = results.getDouble(5);
                int status=results.getInt(6);
                int productAmount = getFoodAmount(productId);
                ArrayList<Image> listImage=getListFoodImage(productId);
                Food food = new Food(productId,productName,productType,productPrice,productAmount,null,status,origin);
                listFood.add(food);
            }
        } catch (Exception e) {
            System.err.println("Loi database method listFood class ProductRepository");
        }
        return listFood;
    }
//    public static Pet getPet(String id ) {
//        try {
//            String query = "select * from tblPet where PetID = ? ";
//            Connection con = DBConnect.getConnection();
//            PreparedStatement stmt = con.prepareStatement(query);
//            stmt.setString(1, id);
//            ResultSet results = stmt.executeQuery();
//            while (results.next()) {
//                String productId = results.getString(1);
//                String productName = results.getString(2);
//                String petColor = results.getString(3);
//                String productType = results.getString(4);
//                double productPrice = results.getDouble(5);
//                int productAmount = results.getInt(6);
//                Pet pet = new Pet(productId, productName, productType, productPrice, productAmount, petColor);
//                return pet;
//            }
//        }catch(Exception e) {
//            System.out.println("Loi method GetPet() trong ProductRepository.java ");
//        }
//        return null;
//    }
//    public static Food getFood(String id ) {
//        try {
//            String query = "select * from tblFood where FoodID = ? ";
//            Connection con = DBConnect.getConnection();
//            PreparedStatement stmt = con.prepareStatement(query);
//            stmt.setString(1, id);
//            ResultSet results = stmt.executeQuery();
//            while (results.next()) {
//                String productId = results.getString(1);
//                String productName = results.getString(2);
//                String productType = results.getString(3);
//                double productPrice = results.getDouble(4);
//                int productAmount = results.getInt(5);
//                Food food = new Food(productId, productName, productType, productPrice, productAmount);
//                return food;
//            }
//            con.close();
//        }catch(Exception e) {
//            System.out.println("Loi method GetFood() trong ProductRepository.java ");
//        }
//        return null;
//    }
//

    public static void main(String[] args) {
//                ArrayList<Pet> listPet = listPet();
//                for (Pet pet : listPet) {
//                    System.out.println(pet);
//
//        }
//                System.out.println(listPet.size());
//        ArrayList<Food> listFood = listFood();
//        for (Food food : listFood) {
//            System.out.println(food);
//
//        }
//        System.out.println(listFood.size());
        for (Food pet: getListFood()
             ) {
            System.out.println(pet);
            for (Image img: getListFoodImage(pet.getProductId())
                 ) {
                System.out.println(img);
            }
        }
       // System.out.println(getFoodAmount("F0001"));
    }
}
