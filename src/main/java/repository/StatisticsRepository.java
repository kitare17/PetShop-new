package repository;

import config.DBConnect;
import entity.Food;
import org.glassfish.jersey.internal.inject.ForeignDescriptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StatisticsRepository {


    public static int getUserAmount() {

        try {
            Connection con = DBConnect.getConnection();
            String query = "select Count(1) from tblCustomer";

            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next())
                return resultSet.getInt(1);


        } catch (Exception e) {
            System.out.println("loi acceptBill() servicerespository");
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    public static int getNumberOfOrdersToConfirm() {

        try {
            Connection con = DBConnect.getConnection();
            String query = "select count(1) from tblBill t where  t.StatusBill=N'Đang xử lý'";

            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next())
                return resultSet.getInt(1);


        } catch (Exception e) {
            System.out.println("loi acceptBill() servicerespository");
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    public static int getNumberOfPetsLeft() {

        try {
            Connection con = DBConnect.getConnection();
            String query = "select Count(1) from tblPet where StatusPet=1";

            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next())
                return resultSet.getInt(1);


        } catch (Exception e) {
            System.out.println("loi acceptBill() servicerespository");
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    public static double getOrderRevenue() {

        try {
            Connection con = DBConnect.getConnection();
            String query = "select  SUM(PriceAtPuchase) from tblBill b\n" +
                    "\tjoin tblOrderDetails o on o.BillID=b.BillID\n" +
                    "\t where b.StatusBill=N'Đã thanh toán' and  YEAR(b.DateCreate)=2023";

            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next())
                return resultSet.getDouble(1);


        } catch (Exception e) {
            System.out.println("loi acceptBill() servicerespository");
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    public static ArrayList<Food> getListRankOfFood() {
        ArrayList<Food> listFood = null;
        try {
            Connection con = DBConnect.getConnection();
            String query = " select x.ProductID,f.FoodName,x.AmountProduct \n" +
                    "\t from(\n" +
                    "\tselect o.ProductID,Sum(o.AmountProduct) as AmountProduct  from tblBill b\n" +
                    "\tjoin tblOrderDetails o on o.BillID=b.BillID\n" +
                    "\twhere b.StatusBill=N'Đã thanh toán' and  YEAR(b.DateCreate)=2023\n" +
                    "\tgroup by o.ProductID\n" +
                    "\t  ) as x\n" +
                    "\t  join  tblFood f on x.ProductID=f.FoodID\n" +
                    "\t  order by x.AmountProduct desc";

            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            listFood = new ArrayList<Food>();
            while (resultSet.next()) {
                String foodID = resultSet.getString(1);
                String foodName = resultSet.getString(2);
                int foodAmount = resultSet.getInt(3);
                Food food = new Food();
                food.setProductId(foodID);
                food.setProductName(foodName);
                food.setProductAmount(foodAmount);
                listFood.add(food);
            }


        } catch (Exception e) {
            System.out.println("loi acceptBill() servicerespository");
            e.printStackTrace();
            return null;
        }
        return listFood;
    }

    public static void main(String[] args) {
  ArrayList<Food> list=getListRankOfFood();
        for (Food food:
           list) {
            System.out.println(list.indexOf(food)+1+food.getProductName()+food.getProductId()+food.getProductAmount());
        }

    }
}
