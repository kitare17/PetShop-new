package repository;
import config.DBConnect;
import entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class AdminRepository {
    public static int getAmountUser() {
        try {
            String query = "select count(1) from tblUser";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                return results.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Loi method getAmountUser() trong AdminRepository .java ");
        }
        return 0;
    }

    public static int getCustomerOrder() {
        int amount = 0;
        try {
            String query = "  select count( distinct UserName) from tblOrder";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                amount = results.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Loi method getCustomerOrder() trong AdminRepository .java ");
        }
        return amount;
    }

    public static ArrayList<Pet> getAllPet() {
        ArrayList<Pet> listPet = null;
        try {
            String query = "  select * from tblPet";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet results = stmt.executeQuery();
            listPet = new ArrayList<>();
            while (results.next()) {
                String productId = results.getString(1);
                String productName = results.getString(2);
                String petColor = results.getString(3);
                String productType = results.getString(4);
                double productPrice = Double.parseDouble(results.getString(5));
                int productAmount = Integer.parseInt(results.getString(6));
                Pet pet = new Pet(productId, productName, productType, productPrice, productAmount, petColor);
                listPet.add(pet);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Loi method getAllPet() trong AdminRepository .java ");
        }
        return listPet;
    }

    public static ArrayList<Food> getAllFood() {
        ArrayList<Food> listFood = null;
        try {
            String query = "  select * from tblFood";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet results = stmt.executeQuery();
            listFood = new ArrayList<>();
            while (results.next()) {
                String productId = results.getString(1);
                String productName = results.getString(2);
                String productType = results.getString(3);
                double productPrice = Double.parseDouble(results.getString(4));
                int productAmount = Integer.parseInt(results.getString(5));
                Food food = new Food(productId, productName, productType, productPrice, productAmount);
                listFood.add(food);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Loi method getAllFood() trong AdminRepository .java ");
        }
        return listFood;
    }

    public static boolean removeProduct(String idProduct) {
        try {
            Connection con = DBConnect.getConnection();
            String discount = null;
            String query = (idProduct.contains("F")) ? "delete tblFood where FoodID=?" : " delete tblPet where PetID=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, idProduct);
            stmt.executeUpdate();

            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Loi method removeProduct(String idProduct) trong ProductRepository.java ");
            e.printStackTrace();
        }

        return false;
    }

    public static boolean addPet(Pet pet) {
        try {
//         insert into tblOrder values ('123','2022-12-12',null,'antunglam985',1)
            Connection con = DBConnect.getConnection();
            String discount = null;
            String query = "insert into tblPet values (?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, pet.getProductId());
            stmt.setString(2, pet.getProductName());
            stmt.setString(3, pet.getPetColor());
            stmt.setString(4, pet.getProductType());
            stmt.setDouble(5, pet.getProductPrice());
            stmt.setInt(6, pet.getProductAmount());
            stmt.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Loi method removeProduct(String idProduct) trong ProductRepository.java ");
            e.printStackTrace();
        }

        return false;
    }

    public static boolean addFood(Food food) {
        try {
//         insert into tblOrder values ('123','2022-12-12',null,'antunglam985',1)
            Connection con = DBConnect.getConnection();
            String discount = null;
            String query = " insert into tblFood values(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, food.getProductId());
            stmt.setString(2, food.getProductName());
            stmt.setString(3, food.getProductType());
            stmt.setDouble(4, food.getProductPrice());
            stmt.setInt(5, food.getProductAmount());
            stmt.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Loi method removeProduct(String idProduct) trong ProductRepository.java ");
            e.printStackTrace();
        }

        return false;
    }

    public static boolean addService(Service service) {
        try {
            Connection con = DBConnect.getConnection();
            String query = " insert into tblService values(?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, service.getServiceID());
            stmt.setString(2, service.getServiceName());
            stmt.setDouble(3, service.getServicePrice());
            stmt.executeUpdate();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Loi method addService(Service service) trong ProductRepository.java ");
            e.printStackTrace();
        }

        return false;
    }

    public static ArrayList<OrderAccept> getAllOrder() {
        ArrayList<OrderAccept> list = null;
        try {
            Connection con = DBConnect.getConnection();
            String query = "select x.OrderID,x.UserName,x.OrDate,x.DiscountID,x.OrderStatus,sum(x.total) as total\n"
                    + "  from\n"
                    + "  (\n"
                    + "  (select od.OrderID,od.UserName,od.OrDate,od.DiscountID,od.OrderStatus,sum(dt.BuyAmount*f.FoodPrice) as total\n"
                    + "  from tblOrder od\n"
                    + "  join tblOrderDetail dt on od.OrderID=dt.OrderID \n"
                    + "  join tblFood f on f.FoodID=dt.ProductID\n"
                    + "  group by od.OrderID,od.UserName,od.OrDate,od.DiscountID,od.OrderStatus)\n"
                    + "  union\n"
                    + "  (\n"
                    + "  select od.OrderID,od.UserName,od.OrDate,od.DiscountID,od.OrderStatus,sum(dt.BuyAmount*p.PetPrice) as total\n"
                    + "  from tblOrder od\n"
                    + "  join tblOrderDetail dt on od.OrderID=dt.OrderID \n"
                    + "join tblPet p on p.PetID=dt.ProductID\n"
                    + "  group by od.OrderID,od.UserName,od.OrDate,od.DiscountID,od.OrderStatus\n"
                    + "  )\n"
                    + "  union\n"
                    + "  (\n"
                    + "   select od.OrderID,od.UserName,od.OrDate,od.DiscountID,od.OrderStatus,sum(dt.BuyAmount*s.ServicePrice) as total\n"
                    + "  from tblOrder od\n"
                    + "  join tblOrderDetail dt on od.OrderID=dt.OrderID \n"
                    + " join tblService s on s.ServiceID=dt.ProductID\n"
                    + "  group by od.OrderID,od.UserName,od.OrDate,od.DiscountID,od.OrderStatus\n"
                    + "  ))x\n"
                    + "  group by x.OrderID,x.UserName,x.OrDate,x.DiscountID,x.OrderStatus ";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet results = stmt.executeQuery();
            list = new ArrayList<>();
            while (results.next()) {
                String idOrder = results.getString(1),
                        username = results.getString(2),
                        date = results.getString(3),
                        discountId = results.getString(4),
                        total = results.getString(6),
                        orderStatus = results.getString(5);
                OrderAccept od = new OrderAccept(idOrder, username, date, discountId, total, orderStatus);

                list.add(od);

            }
            con.close();
        } catch (Exception e) {
            System.out.println("Loi method getAllOrder trong AdminRepository.java ");
            e.printStackTrace();
        }

        return list;
    }

    public static void acceptOrder(String id) {
        try {
            Connection con = DBConnect.getConnection();
            String query = " update tblOrder set OrderStatus=N'Đã xác nhận' where tblOrder.OrderID=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, id);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("Loi method acceptOrder(String id) trong AdminRepository.java");
        }
    }

    public static void removeOrder(String id) {
        try {
            Connection con = DBConnect.getConnection();
            String query = " delete tblOrderDetail  where tblOrderDetail.OrderID=?\n"
                    + "delete tblOrder  where tblOrder.OrderID=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, id);
            stmt.setString(2, id);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("Loi method acceptOrder(String id) trong AdminRepository.java");
        }
    }

    public static ArrayList<StatisticAge> getAllAge() {
        ArrayList<StatisticAge> list = null;
        try {
            Connection con = DBConnect.getConnection();
            String query = "select  u.UserAge, count(u.UserAge) from tblUser u group by u.UserAge";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                list.add(new StatisticAge(rs.getInt(1), rs.getInt(2)));
            }

            con.close();
        } catch (Exception e) {
            System.out.println("Loi method acceptOrder(String id) trong AdminRepository.java");
        }
        return list;
    }

    public static ArrayList<StatisticAge> getAllOrderMonth() {
        ArrayList<StatisticAge> list = null;
        try {
            Connection con = DBConnect.getConnection();
            String query = "  select MONTH(o.OrDate), COUNT(MONTH(o.OrDate)) from  tblOrder o \n"
                    + "where o.OrderStatus!=N'Đang xử lí' and o.OrDate>='2023-01-01' and o.OrDate<='2023-12-30'\n"
                    + "group by MONTH(o.OrDate)";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                list.add(new StatisticAge(rs.getInt(1), rs.getInt(2)));

            }

            con.close();
        } catch (Exception e) {
            System.out.println("Loi method acceptOrder(String id) trong AdminRepository.java");
        }
        return list;
    }
    public static void updateFood(Food food) {
        try {
            Connection con = DBConnect.getConnection();
            String query = " update tblFood set  FoodName=?,FoodType=?, FoodPrice=? ,FoodAmount =? where FoodID=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, food.getProductName());
            stmt.setString(2, food.getProductType());
            stmt.setDouble(3, food.getProductPrice());
            stmt.setInt(4, food.getProductAmount());
            stmt.setString(5,food.getProductId());
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("Loi method updateFood(Food food) trong AdminRepository.java");
        }
    }
    public static void updatePet(Pet pet) {
        try {
            Connection con = DBConnect.getConnection();
            String query = " update tblPet set PetName=?,PetColor=? ,PetType=?,PetPrice =?,PetAmount=?   where PetID=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, pet.getProductName());
            stmt.setString(2, pet.getPetColor());
            stmt.setString(3, pet.getProductType());
            stmt.setDouble(4, pet.getProductPrice());
            stmt.setInt(5, pet.getProductAmount());
            stmt.setString(6,pet.getProductId());
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("Loi method updateFood(Food food) trong AdminRepository.java");
        }
    }
    public static void main(String[] args) {
        ArrayList<StatisticAge> listPet = AdminRepository.getAllOrderMonth();
        for (StatisticAge pet : listPet) {
            System.out.println(pet);
        }

    }
}
