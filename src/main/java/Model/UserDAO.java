package Model;

import Entity.Image;
import Entity.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {
    public static boolean updateUser(String userID, String firstname, String lastname, String address, String phone) {
        try {
            String query;
            if (userID.startsWith("A"))
                query = "Update tblAdmin \n" +
                        "set FirstnameAd =?, LastnameAd= ?, AddressAd=?,PhoneAd=?\n" +
                        "where AdminID = ?";
            else if (userID.startsWith("E"))
                query = "Update tblEmployee \n" +
                        "set FirstnameEmp =?, LastnameEmp= ?, AddressEmp=?,PhoneEmp=?\n" +
                        "where EmployeeID = ?";
            else query = "Update tblCustomer \n" +
                        "set FirstnameCus =?, LastnameCus= ?, AddressCus=?,PhoneCus=?\n" +
                        "where CustomerID = ?";

            Connection con = PetShopDB.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            preSt.setString(1, firstname);
            preSt.setString(2, lastname);
            preSt.setString(3, address);
            preSt.setString(4, phone);
            preSt.setString(5, userID);

            preSt.executeUpdate();
            con.close();
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static boolean checkExistID(String userID) {

            try {
                String query;
                if (userID.startsWith("A"))
                    query = "select AdminID from tblAdmin where AdminID=?";
                else if (userID.startsWith("E"))
                    query = "select EmployeeID from tblEmployee where EmployeeID=?";
                else query ="select CustomerID from tblCustomer where CustomerID=?";

                Connection con = PetShopDB.getConnection();
                PreparedStatement preSt = con.prepareStatement(query);
                preSt.setString(1,userID);
                 ResultSet rs=preSt.executeQuery();
                 boolean checkID= rs.next();
                con.close();
                 return checkID;

            } catch (Exception e) {

                e.printStackTrace();
                return false;
            }

    }


    public static boolean addEmployee(String userID, String firstname, String lastname, String address, String phone,String username,String password) {

        try {

            String query="\n" +
                    "insert into tblEmployee values \n" +
                    "(?,?,?,?,?)\n";


            Connection con = PetShopDB.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            preSt.setString(1, userID);
            preSt.setString(2, firstname);
            preSt.setString(3, lastname);
            preSt.setString(4, address);
            preSt.setString(5, phone);

            //insert to tblCustomer
            preSt.executeUpdate();
            //inster to tblAccount
            query="insert into tblAccount values\n" +
                    "(?,?,?,1)";

            preSt= con.prepareStatement(query);
            preSt.setString(1,username);
            preSt.setString(2,password);
            preSt.setString(3,userID);
            preSt.executeUpdate();
            con.close();
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static boolean addCustomer(String userID, String firstname, String lastname, String address, String phone,String username,String password) {


        try {

            String query="\n" +
                    "insert into tblCustomer values \n" +
                    "(?,?,?,?,?)\n";


            Connection con = PetShopDB.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            preSt.setString(1, userID);
            preSt.setString(2, firstname);
            preSt.setString(3, lastname);
            preSt.setString(4, address);
            preSt.setString(5, phone);

            //insert to tblCustomer
            preSt.executeUpdate();
            //inster to tblAccount
            query="insert into tblAccount values\n" +
                    "(?,?,?,1)";
            preSt= con.prepareStatement(query);
            preSt= con.prepareStatement(query);
            preSt.setString(1,username);
            preSt.setString(2,password);
            preSt.setString(3,userID);
            preSt.executeUpdate();

            con.close();
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //test updateUser
        //updateUser("0001","Nguyễn","Huệ","Đà Nẵng","0123456789");
        //test addCustomer
        //addCustomer("C0004","Nguyễn","Huệ","Đà Nẵng","0123456789","khoatest","123");
        //test addEmployee
       //addEmployee("E0004","Nguyễn","Huệ","Đà Nẵng","0123456789","khoatest1","123");
        //check checkExistID
        System.out.println(checkExistID("C0001"));

    }
}
