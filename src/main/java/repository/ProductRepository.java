package repository;

import config.DBConnect;
import entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductRepository {
    public static ArrayList<Image> getListPetImage(String petID) {
        ArrayList<Image> images = new ArrayList<>();
        try {
            String query = "select * from tblPetImage where PetID =?";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, petID);
            ResultSet results = stmt.executeQuery();

            while (results.next()) {
                String url = results.getString(2);
                Image img = new Image(petID, url);
                images.add(img);
            }
        } catch (Exception e) {
            System.err.println("Loi database method getListPetImage class ProductRepository");
        }
        return images;
    }

    public static ArrayList<Image> getListFoodImage(String foodID) {
        ArrayList<Image> images = new ArrayList<>();
        try {
            String query = "select * from tblFoodImage where FoodID =?";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, foodID);
            ResultSet results = stmt.executeQuery();

            while (results.next()) {
                String url = results.getString(2);
                Image img = new Image(foodID, url);
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
                int productStatus = results.getInt(5);
                ArrayList<Image> images = getListPetImage(productId);

                Pet pet = new Pet(productId, productName, productType, productPrice, productAmount, images, productStatus);
                listPet.add(pet);
            }
        } catch (Exception e) {
            System.err.println("Loi database method listPet class ProductRepository");
        }
        return listPet;
    }
    public static ArrayList<Pet> getListPetPage(String page) {
        ArrayList<Pet> listPet = new ArrayList<Pet>();
        try {
            String query = "select * from tblPet\n" +
                    " order by PetID\n" +
                    " OFFSET (? - 1) * 9 ROWS \n" +
                    " FETCH NEXT 9 ROWS ONLY";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,page);
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                String productId = results.getString(1);
                String productName = results.getString(2);
                String productType = results.getString(3);
                double productPrice = results.getDouble(4);
                int productAmount = 1;
                int productStatus = results.getInt(5);
                ArrayList<Image> images = getListPetImage(productId);

                Pet pet = new Pet(productId, productName, productType, productPrice, productAmount, images, productStatus);
                listPet.add(pet);
            }
        } catch (Exception e) {
            System.err.println("Loi database method listPet class ProductRepository");
        }
        return listPet;
    }
    public static ArrayList<Pet> getListCat() {
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
                int productStatus = results.getInt(5);
                ArrayList<Image> images = getListPetImage(productId);

                Pet pet = new Pet(productId, productName, productType, productPrice, productAmount, images, productStatus);
                listPet.add(pet);
            }
        } catch (Exception e) {
            System.err.println("Loi database method getListCat class ProductRepository");
        }
        return listPet;
    }

    public static ArrayList<Pet> getListDog() {
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
                int productStatus = results.getInt(5);
                ArrayList<Image> images = getListPetImage(productId);

                Pet pet = new Pet(productId, productName, productType, productPrice, productAmount, images, productStatus);
                listPet.add(pet);
            }
        } catch (Exception e) {
            System.err.println("Loi database method getListCat class ProductRepository");
        }
        return listPet;
    }

    // TODO: 5/30/2023  them tru so luong da ban trong bill
    public static int getFoodAmount(String FoodID) {
        int amount = 0;
        try {
            String query = "select sum(Amount) from tblImported where FoodID=?";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, FoodID);
            ResultSet results = stmt.executeQuery();

            while (results.next()) {
                amount = results.getInt(1);
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
                String origin = results.getString(4);
                double productPrice = results.getDouble(5);
                int status = results.getInt(6);
                int productAmount = getFoodAmount(productId);
                ArrayList<Image> listImage = getListFoodImage(productId);
                Food food = new Food(productId, productName, productType, origin, productPrice, productAmount, listImage, status);
                listFood.add(food);

            }
        } catch (Exception e) {
            System.err.println("Loi database method listFood class ProductRepository");
        }
        return listFood;
    }
    public static ArrayList<Food> getListFoodPage(String page) {
        ArrayList<Food> listFood = new ArrayList<Food>();
        try {
            String query = "select * from tblFood\n" +
                    "order by FoodID\n" +
                    "OFFSET (? - 1) * 9 ROWS\n" +
                    "FETCH NEXT 9 ROWS ONLY;";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,page);
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                String productId = results.getString(1);
                String productName = results.getString(2);
                String productType = results.getString(3);
                String origin = results.getString(4);
                double productPrice = results.getDouble(5);
                int status = results.getInt(6);
                int productAmount = getFoodAmount(productId);
                ArrayList<Image> listImage = getListFoodImage(productId);
                Food food = new Food(productId, productName, productType, origin, productPrice, productAmount, listImage, status);
                listFood.add(food);

            }
        } catch (Exception e) {
            System.err.println("Loi database method listFood class ProductRepository");
        }
        return listFood;
    }
    public  static int getFoodSize(){
        int size=0;
        try {
            String query = "select COUNT(1) from tblFood";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);

            ResultSet results = stmt.executeQuery();
            while (results.next()) {
               size=results.getInt(1);

            }
        } catch (Exception e) {
            System.err.println("Loi database method listFood class ProductRepository");
        }
        return size;
    }
    public  static int getPetSize(){
        int size=0;
        try {
            String query = "select COUNT(1) from tblPet";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);

            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                size=results.getInt(1);

            }
        } catch (Exception e) {
            System.err.println("Loi database method listFood class ProductRepository");
        }
        return size;
    }
    public static Pet getPet(String id) {
        try {
            String query = "SELECT * FROM  tblPet f join tblPetImage i  on f.PetID = i.PetID where f.PetID = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                String productId = results.getString(1);
                String productName = results.getString(2);
                String productType = results.getString(3);
                double productPrice = results.getDouble(4);
                int status = results.getInt(5);

                String imgUrl = results.getString(7);
                ArrayList<Image> listImage = new ArrayList<>();
                Image image = new Image(id, imgUrl);
                listImage.add(image);

                Pet pet = new Pet(productId, productName, productType, productPrice, 1, listImage, status);
                return pet;
            }
        } catch (Exception e) {
            System.out.println("Loi method GetPet() trong ProductRepository.java ");
        }
        return null;
    }
    public static Service getService(String id) {
        try {
            String query = "SELECT * FROM tblService s join tblServiceImage i  on s.ServiceID = i.ServiceID where s.ServiceID =?";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                String serviceId = results.getString(1);
                String serviceName = results.getString(2);
                double servicePrice = results.getDouble(3);
                int status = results.getInt(4);
                String serviceDesription = results.getString(5);
                String imgUrl = results.getString(7);
                ArrayList<Image> listImage = new ArrayList<>();
                Image image = new Image(id, imgUrl);
                listImage.add(image);
                Service service = new Service(serviceId,serviceName,servicePrice,status,serviceDesription,listImage);
                return service;
            }
        } catch (Exception e) {
            System.out.println("Loi method GetService(id) trong ProductRepository.java ");
            e.printStackTrace();
        }
        return null;
    }

    public static Food getFood(String id) {
        try {
            String query = "SELECT * FROM  tblFood f join tblFoodImage i  on f.FoodID = i.FoodID join tblImported im on f.FoodID = im.FoodID where f.FoodID = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                String productId = results.getString(1);
                String productName = results.getString(2);
                String productType = results.getString(3);
                String productOrigin = results.getString(4);
                double productPrice = results.getDouble(5);
                int status = results.getInt(6);
                String imgUrl = results.getString(8);

                int productAmmount = results.getInt(11);
                ArrayList<Image> listImage = new ArrayList<>();
                Image image = new Image(id, imgUrl);
                listImage.add(image);
                Food food = new Food(productId, productName, productType, productOrigin, productPrice, productAmmount, listImage, status);
                return food;
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Loi method GetFood() trong ProductRepository.java ");
        }
        return null;
    }
    public static Food getFoodInfor(String id) {
        try {
            String query = "SELECT * FROM  tblFood f where f.FoodID = ?";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                String productId = results.getString(1);
                String productName = results.getString(2);
                String productType = results.getString(3);
                String productOrigin = results.getString(4);
                double productPrice = results.getDouble(5);
                int status = results.getInt(6);

                Food food = new Food(productId, productName, productType, productOrigin, productPrice, 0, null, status);
                return food;
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Loi method getFoodInfor() trong ProductRepository.java ");
        }
        return null;
    }

    public static boolean checkExistPetID(String petID) {
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("select PetID from tblPet where PetID=?");
            stmt.setString(1, petID);
            ResultSet resultSet = stmt.executeQuery();
            return resultSet.next();

        } catch (Exception e) {
            System.out.println("loi checkExistPetID((String petID))");
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkExistFoodID(String foodID) {
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("select FoodID from tblFood where FoodID=?");
            stmt.setString(1, foodID);
            ResultSet resultSet = stmt.executeQuery();
            return resultSet.next();

        } catch (Exception e) {
            System.out.println("loi checkExistFoodID(String foodID)");
            e.printStackTrace();
        }
        return false;
    }

    public static boolean addPet(Pet pet) {
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("insert into tblPet(petid, petname, pettype, petprice, statuspet)\n" +
                    "values (?,?,?,?,?)");
            stmt.setString(1, pet.getProductId());
            stmt.setString(2, pet.getProductName());
            stmt.setString(3, pet.getProductType());
            stmt.setDouble(4, pet.getProductPrice());
            stmt.setInt(5, pet.getStatus());
            stmt.executeUpdate();
            for (Image img : pet.getListImg()) {
                addPetImg(img);
            }
        } catch (Exception e) {
            System.out.println("loi addPet(Pet pet)");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean addPetImg(Image petImg) {
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("insert into  tblPetImage(PetID, URLPetImage) \n" +
                    "values (?,?)");
            stmt.setString(1, petImg.getId());
            stmt.setString(2, petImg.getUrl());

            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("loi addPetImg(Image petImg)");
            e.printStackTrace();
            return false;
        }
        return true;
    }





    public static boolean updatePet(Pet pet) {
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("update tblPet\n" +
                    "set PetName=?, PetType=?,PetPrice=?, StatusPet=?\n" +
                    "where PetID=?");
            stmt.setString(1, pet.getProductName());
            stmt.setString(2, pet.getProductType());
            stmt.setDouble(3, pet.getProductPrice());
            stmt.setInt(4, pet.getStatus());
            stmt.setString(5,pet.getProductId());

            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("loi updatePet(Pet pet)");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean addFood(Food food) {
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("insert into tblFood (FoodID, FoodName, FoodType, Origin, FoodPrice, StatusFood) \n" +
                    "values (?,?,?,?,?,?)");
            stmt.setString(1, food.getProductId());
            stmt.setString(2, food.getProductName());
            stmt.setString(3, food.getProductType());
            stmt.setString(4, food.getOrigin());
            stmt.setDouble(5, food.getProductPrice());
            stmt.setInt(6, food.getStatus());
            stmt.executeUpdate();
            for (Image img : food.getListImg()) {
                addFoodImg(img);
            }
        } catch (Exception e) {
            System.out.println("loi addFood(Food food)");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean addFoodImg(Image FoodImg) {
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("insert into tblFoodImage(FoodID, URLFoodImage)  \n" +
                    "values (?,?)");
            stmt.setString(1, FoodImg.getId());
            stmt.setString(2, FoodImg.getUrl());

            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("loi addFoodImg(Image FoodImg)");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean UpdateFood(Food food) {
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("update  tblFood set FoodName=?\n" +
                    "                 ,FoodType=?\n" +
                    "                 ,Origin=?\n" +
                    "                 ,FoodPrice=?\n" +
                    "                 ,StatusFood=?\n" +
                    "                 where FoodID= ?");
            stmt.setString(1, food.getProductName());
            stmt.setString(2, food.getProductType());
            stmt.setString(3, food.getOrigin());
            stmt.setDouble(4, food.getProductPrice());
            stmt.setInt(5, food.getStatus());
            stmt.setString(6,food.getProductId());
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("loi addFood(Food food)");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static boolean addImportedFood(ImportedFood importedFood){

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("insert into tblImported(FoodID, Consignment, Amount, DateImported) " +
                    "values (?,?,?,?)");
            stmt.setString(1,importedFood.getFoodID());
            stmt.setString(2,importedFood.getImportName());
            stmt.setInt(3,importedFood.getImportAmount());
            stmt.setString(4,importedFood.getImportDate());
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("loi addImportedFood(ImportedFood ImportedFood)");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static ArrayList<ImportedFood> getListImportedFood(String foodID){
             ArrayList<ImportedFood> listImportedFood=new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from tblImported where FoodID=?");
           stmt.setString(1,foodID);
           ResultSet rs= stmt.executeQuery();
           while (rs.next()){

               String importName=rs.getString(2);
               int importAmount=rs.getInt(3);
               String importDate=rs.getString(4);
               ImportedFood importedFood=new ImportedFood(foodID,importName,importAmount,importDate);
               listImportedFood.add(importedFood);
           }

        } catch (Exception e) {
            System.out.println("loi addImportedFood(ImportedFood ImportedFood)");
            e.printStackTrace();
           return null;
        }
        return listImportedFood;
    }
    public static boolean addFoodImage(String foodID,String url){

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("    insert into tblFoodImage(FoodID, URLFoodImage) values (?,?)\n");
            stmt.setString(1,foodID);
            stmt.setString(2,url);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("loi addFoodImage(String foodID,String url)");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean removeFoodImage(String foodID,String url){

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("  delete tblFoodImage where URLFoodImage=? and FoodID=?  ");
            stmt.setString(2,foodID);
            stmt.setString(1,url);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("loi addFoodImage(String foodID,String url)");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static boolean removePetImage(String petID,String url){

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("  delete tblPetImage where URLPetImage=? and PetID=?  ");
            stmt.setString(2,petID);
            stmt.setString(1,url);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("loi removePetImage(String petID,String url)");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
//                ArrayList<Pet> listPet = listPet();
//                for (Pet pet : listPet) {
//                    System.out.println(pet);
//
//        }
//                System.out.println(listPet.size());

//        System.out.println(listFood.size());
//        for (Food pet: getListFood()
//             ) {
//            System.out.println(pet);
//            for (Image img: getListFoodImage(pet.getProductId())
//                 ) {
//                System.out.println(img);
//            }
//        }
        // System.out.println(getFoodAmount("F0001"));
//        System.out.println(checkExistFoodID("F0001"));
//        Pet pet = new Pet("P0041", "test", "dog", 5000, 1, null, 1);
//        addPet(pet);
        System.out.println(getPetSize());

    }
}
