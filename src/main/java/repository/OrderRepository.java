package repository;
import config.DBConnect;
import entity.*;
import service.Isvalid;
import service.RandomGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class OrderRepository {
    public static String getOrderId() {
        try {
            String OrderId = RandomGenerator.generateRandomString();
            String query = "select BillID from tblBill";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet results = stmt.executeQuery();
            ArrayList<String> listOrderID = new ArrayList<>();
            while (results.next()) {
                String OrderIdDB = results.getString(1);
                listOrderID.add(OrderIdDB);
            }
            for (String oDB : listOrderID) {
                if (oDB.equals(OrderId)) {
                    OrderId = RandomGenerator.generateRandomString();
                }
            }
            return OrderId;
        } catch (Exception e) {
            System.out.println("Loi method checkExistOrder(Cart cart ) trong OrderRepository.java ");
        }
        return null;
    }

    public static String createOrder(Cart cart, User user) {
        try {
            Connection con = DBConnect.getConnection();
            String query = "insert into tblBill (BillID,CustomerID,AddressDelivery,DateCreate,PreferentialID,StatusBill) values (?,?,?,?,?,?)";
            String orderID = getOrderId();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, orderID);
            stmt.setString(2, user.getUserId());
            stmt.setString(3, user.getAddress());
            stmt.setString(4, Isvalid.getCurrentDate());
            stmt.setString(5, cart.getDiscountCode());
            stmt.setString(6, "Đang xử lý");
            stmt.executeUpdate();
            con.close();
            createOrderDetail(cart, orderID);
            return orderID;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi method createOrder(Cart cart, User user) trong OrderRepository.java ");
        }
        return null;
    }

    public static boolean createOrderDetail(Cart cart, String orderId) {
        System.out.println("=>>>>....>>>>>>>>>>>>>>>>>>>>>>>" + orderId);
        System.out.println(cart.getCart());
        System.out.println(cart.getCart().get(0).getProduct().getProductId());
        System.out.println(cart.getCart().get(0).getProduct().getProductAmount());
        System.out.println(cart.getCart().get(0).getProduct().getProductPrice());
        for (Items i : cart.getCart()) {
            try {
                Connection con = DBConnect.getConnection();
                String query = "insert into tblOrderDetails values (?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, orderId);
                stmt.setString(2, i.getProduct().getProductId());
                stmt.setInt(3, i.getAmmout());
                stmt.setDouble(4,i.getPrice());
                stmt.executeUpdate();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Loi method createOrderDetail(Cart cart,String orderId) trong OrderRepository.java ");

            }
        }
        return true;
    }
///bugggggggggggggggggggggggggggggggggggggggggggggg
    public static ArrayList<Items> getOrder(String OrderId) {
        try {
            ArrayList<Items> orderedList = new ArrayList<>();
            Connection con = DBConnect.getConnection();
            String query = "select * from tblOrderDetails where BillID = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, OrderId);
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                Items item = new Items();
                item.setAmmout(results.getInt(3));
                item.setProduct(getProductById(results.getString(2)));
                orderedList.add(item);
            }
            con.close();
            return orderedList;
        } catch (Exception e) {
            System.out.println("=============>ERROR :  ArrayList<Items> getOrder(String OrderId) <==============");
        }
        return null;
    }

    public static Product getProductById(String orderdetailId) {
        try {
            Connection con = DBConnect.getConnection();
            String query = (orderdetailId.contains("F")) ? "select * from tblFood where FoodID=?" : " select * from tblPet where PetID=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, orderdetailId);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                if (orderdetailId.contains("F")) {
                    String id = results.getString(1);
                    String name = results.getString(2);
                    double price = results.getDouble(5);
                    con.close();
                    return new Product(id, name, price);
                } else {
                    String id = results.getString(1);
                    String name = results.getString(2);
                    double price = results.getDouble(4);
                    con.close();
                    return new Product(id, name, price);
                }
            }
            con.close();
            return null;

        } catch (Exception e) {
            System.out.println("=========>ERROR :getProductById(String orderdetailId) <===========");
        }
        return null;
    }

    public static String getOrderStatus(String orderId) {
        String id = null;
        try {
            Connection con = DBConnect.getConnection();
            String query = "select StatusBill from tblBill where BillID = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, orderId);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                id = results.getString(1);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("==========>ERROR : getOrderStatus()<=============");
        }
        return id;
    }

    public static ArrayList<String> getOrderIdList(String userId) {
        ArrayList<String> listOrderId = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String query = "select BillID from tblBill where CustomerID = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, userId);
            ResultSet results = stmt.executeQuery();
            while (results.next()) {
                listOrderId.add(results.getString(1));
            }
            con.close();
        } catch (Exception e) {
            System.out.println("==========>ERROR : getOrderIdList(String userId)<=============");
        }
        return listOrderId;
    }

    public static String getOrderDate(String orderId) {
        String date = null;
        try {
            Connection con = DBConnect.getConnection();
            String query = "select DateCreate from tblBill where BillID= ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, orderId);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                date =  results.getString(1);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("==========>ERROR : getOrderStatus()<=============");
        }
        return date;
    }
    public static boolean acceptOrder(String orderId,String employeeID){

        try {
            Connection con = DBConnect.getConnection();
            String query = "update tblBill set StatusBill=N'Đã xác nhận',EmployeeID=? where BillID=?";
            PreparedStatement stmt = con.prepareStatement(query);
            String accept="Đã xác nhận";
            stmt.setString(1, employeeID);

            stmt.setString(2, orderId);
          stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("==========>ERROR : acceptOrder()<=============");
            return false;
        }
        return true;
    }
    public static boolean cancelOrder(String orderId,String employeeID){

        try {
            Connection con = DBConnect.getConnection();
            String query = "update tblBill set StatusBill=N'Đã hủy',employeeID=?  where BillID=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, employeeID);
            stmt.setString(2, orderId);
            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("==========>ERROR : cancelOrder()<=============");
            return false;
        }
        return true;
    }
    public static  ArrayList<OrderAccept> getAllOrder(){
        ArrayList<OrderAccept>listOrder;
        try {
           listOrder =new ArrayList<>();
            Connection con = DBConnect.getConnection();
            String query = "select * from tblBill where StatusBill=N'Đang xử lý'";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                String orderID=rs.getString(1);
                String employeeID=rs.getString(2);
                String username=rs.getString(3);
                String  address=rs.getString(4);
                String date=rs.getString(5);
                String preferentialId=rs.getString(6);
                String status=rs.getString(7);
                OrderAccept orderAccept=new OrderAccept();
                orderAccept.setIdOrder(orderID);
                orderAccept.setUsername(username);
                orderAccept.setAddress(address);
                orderAccept.setDate(date);
                orderAccept.setEmployeeID(employeeID);
                orderAccept.setOrderStatus(status);
                orderAccept.setDiscountId(preferentialId);
                listOrder.add(orderAccept);
            }


            con.close();
        } catch (Exception e) {
            System.out.println("==========>ERROR : getAllOrder()<=============");
            return null;
        }
        return listOrder;
    }
    public static  ArrayList<OrderAccept> getAllOrderAccepted(){
        ArrayList<OrderAccept>listOrder;
        try {
            listOrder =new ArrayList<>();
            Connection con = DBConnect.getConnection();
            String query = "select * from tblBill where StatusBill=N'Đã xác nhận'";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                String orderID=rs.getString(1);
                String employeeID=rs.getString(2);
                String username=rs.getString(3);
                String  address=rs.getString(4);
                String date=rs.getString(5);
                String preferentialId=rs.getString(6);
                String status=rs.getString(7);
                OrderAccept orderAccept=new OrderAccept();
                orderAccept.setIdOrder(orderID);
                orderAccept.setUsername(username);
                orderAccept.setAddress(address);
                orderAccept.setDate(date);
                orderAccept.setEmployeeID(employeeID);
                orderAccept.setOrderStatus(status);
                orderAccept.setDiscountId(preferentialId);
                listOrder.add(orderAccept);
            }


            con.close();
        } catch (Exception e) {
            System.out.println("==========>ERROR : cancelOrder()<=============");
            return null;
        }
        return listOrder;
    }
    public static  ArrayList<OrderAccept> getAllOrderCancel(){
        ArrayList<OrderAccept>listOrder;
        try {
            listOrder =new ArrayList<>();
            Connection con = DBConnect.getConnection();
            String query = "select * from tblBill where StatusBill=N'Đã hủy'";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs=stmt.executeQuery();
            while(rs.next()){
                String orderID=rs.getString(1);
                String employeeID=rs.getString(2);
                String username=rs.getString(3);
                String  address=rs.getString(4);
                String date=rs.getString(5);
                String preferentialId=rs.getString(6);
                String status=rs.getString(7);
                OrderAccept orderAccept=new OrderAccept();
                orderAccept.setIdOrder(orderID);
                orderAccept.setUsername(username);
                orderAccept.setAddress(address);
                orderAccept.setDate(date);
                orderAccept.setEmployeeID(employeeID);
                orderAccept.setOrderStatus(status);
                orderAccept.setDiscountId(preferentialId);
                listOrder.add(orderAccept);
            }


            con.close();
        } catch (Exception e) {
            System.out.println("==========>ERROR : cancelOrder()<=============");
            return null;
        }
        return listOrder;
    }
    public static double getPriceOrdered(String orderId,String productId) {
        System.out.println("cho nay ne" + orderId);
        System.out.println("cho nay ne" + productId);
        double price = 0 ;
        try {
            Connection con = DBConnect.getConnection();
            String query = "select PriceAtPuchase from tblOrderDetails where ProductID=? and BillID =?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, productId);
            stmt.setString(2, orderId);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                price = results.getDouble(1);
                System.out.println("=>>>>>>>>>>>>>>>>>>.." + price);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("==========>ERROR : getPriceOrdered()<=============");
        }
        return price;
    }
    public static double getDiscountPercent(String discountID) {
        double quantity = 0f;
        try {
            Connection con = DBConnect.getConnection();
            String query = "select Quantity from tblPreferential where Preferential =?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, discountID);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                quantity = results.getDouble(1);
                System.out.println("=>>>>>>>>>>>>>>>>>>.." + quantity);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("==========>ERROR : getDiscountPercent()<=============");
        }
        return quantity;
    }
    public static String getDiscountCodeByOrderID(String orderid) {
        String discountCode = null;
        try {
            Connection con = DBConnect.getConnection();
            String query = "select PreferentialID from tblBill where BillID =?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, orderid);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                discountCode = results.getString(1);
                System.out.println("=>>>>>>>>>>>>>>>>>>.." + discountCode);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("==========>ERROR : getDiscountCodeByOrderID()<=============");
        }
        return discountCode;
    }
//    public static void main(String[] args) {
//        System.out.println(getDiscountCodeByOrderID("p83RWai9WM"));
//
//    }
}


