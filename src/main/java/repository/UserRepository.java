package repository;

import config.DBConnect;
import entity.Account;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserRepository {
    public static boolean checkUserNameExist(String username) {
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from tblUser  where UserName =?");
            stmt.setString(1, username);
            ResultSet resultSet = stmt.executeQuery();
            return resultSet.next();

        } catch (Exception e) {
            System.out.println("loi checkUserNameExsit(String userName)");
            e.printStackTrace();
        }
        return false;
    }


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

            Connection con = DBConnect.getConnection();
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
            else query = "select CustomerID from tblCustomer where CustomerID=?";

            Connection con = DBConnect.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            preSt.setString(1, userID);
            ResultSet rs = preSt.executeQuery();
            boolean checkID = rs.next();
            con.close();
            return checkID;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }

    }

    public static boolean checkExistUsername(String username) {
        try {
            String query = "select * from tblAccount where Username=?";
            Connection con = DBConnect.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            preSt.setString(1, username);
            ResultSet rs = preSt.executeQuery();
            boolean checkID = rs.next();
            con.close();
            return checkID;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public static boolean checkExistEmail(String email) {
        try {
            String query = "select * from tblAccount\n" +
                    "where Email=? \n";
            Connection con = DBConnect.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            preSt.setString(1, email);
            ResultSet rs = preSt.executeQuery();
            boolean checkEmail = rs.next();
            con.close();
            return checkEmail;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public static boolean addEmployee(String userID, String firstname, String lastname, String address, String phone, String username, String password) {

        try {

            String query = "\n" +
                    "insert into tblEmployee values \n" +
                    "(?,?,?,?,?)\n";


            Connection con = DBConnect.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            preSt.setString(1, userID);
            preSt.setString(2, firstname);
            preSt.setString(3, lastname);
            preSt.setString(4, address);
            preSt.setString(5, phone);

            //insert to tblCustomer
            preSt.executeUpdate();
            //inster to tblAccount
            query = "insert into tblAccount values\n" +
                    "(?,?,?,1)";

            preSt = con.prepareStatement(query);
            preSt.setString(1, username);
            preSt.setString(2, password);
            preSt.setString(3, userID);
            preSt.executeUpdate();
            con.close();
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static boolean addCustomer(String userID, String firstname, String lastname, String address, String phone, String username, String password, String email) {


        try {

            String query = "insert into tblCustomer(CustomerID,FirstnameCus,LastnameCus,AddressCus,PhoneCus)\n" +
                    "values(?,?,?,?,?)";


            Connection con = DBConnect.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            preSt.setString(1, userID);
            preSt.setString(2, firstname);
            preSt.setString(3, lastname);
            preSt.setString(4, address);
            preSt.setString(5, phone);
            //insert to tblCustomer
            preSt.executeUpdate();
            con.close();
            con = DBConnect.getConnection();
            //inster to tblAccount
            query = "insert into tblAccount (Username,PasswordAcc,UserID,StatusAcc,Email)\n" +
                    "values(?,?,?,1,?)";
            preSt = con.prepareStatement(query);
            preSt.setString(1, username);
            preSt.setString(2, password);
            preSt.setString(3, userID);
            preSt.setString(4, email);

            preSt.executeUpdate();

            con.close();
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static boolean addEmp(String userID, String firstname, String lastname, String address, String phone, String username, String password, String email) {


        try {

            String query = "insert into tblEmployee(EmployeeID,FirstnameEmp,LastnameEmp,AddressEmp,PhoneEmp)\n" +
                    "values(?,?,?,?,?)";


            Connection con = DBConnect.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            preSt.setString(1, userID);
            preSt.setString(2, firstname);
            preSt.setString(3, lastname);
            preSt.setString(4, address);
            preSt.setString(5, phone);
            //insert to tblCustomer
            preSt.executeUpdate();
            con.close();
            con = DBConnect.getConnection();
            //inster to tblAccount
            query = "insert into tblAccount (Username,PasswordAcc,UserID,StatusAcc,Email)\n" +
                    "values(?,?,?,1,?)";
            preSt = con.prepareStatement(query);
            preSt.setString(1, username);
            preSt.setString(2, password);
            preSt.setString(3, userID);
            preSt.setString(4, email);

            preSt.executeUpdate();

            con.close();
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static boolean checkOldPass(String userID, String oldPass) {
        try {
            String query = "select PasswordAcc from tblAccount where UserID=?";
            Connection con = DBConnect.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            preSt.setString(1, userID);
            ResultSet rs = preSt.executeQuery();
            if (rs.next())
                return oldPass.equals(rs.getString(1));
            else return false;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
    public static boolean changePass(String userID, String newPass) {
        try {
            String query = "update tblAccount set PasswordAcc=?\n" +
                    "where UserID=?";
            Connection con = DBConnect.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            preSt.setString(1,newPass);
            preSt.setString(2, userID);
            preSt.executeUpdate();


        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static ArrayList<Account> getListEmpAccount() {
        ArrayList<Account> listEmpAcc;
        try {

            String query = "select acc.Username,acc.UserID,acc.StatusAcc,e.FirstnameEmp as firstname\n" +
                    ",e.LastnameEmp as lastname,e.PhoneEmp as phone,acc.Email from tblAccount acc\n" +
                    "join tblEmployee e on e.EmployeeID=acc.UserID";


            Connection con = DBConnect.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            ResultSet rs=preSt.executeQuery();
            listEmpAcc=new ArrayList<>();
            while(rs.next()){
                String username = rs.getString(1);
                String userID = rs.getString(2);
                int status=rs.getInt(3);

                String firstname = rs.getString(4);
                String lastname = rs.getString(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
               Account newAcc=new Account( username,  userID,  firstname,  lastname,  phone,  email,  status);
               listEmpAcc.add(newAcc);
            }
            con.close();
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
        return listEmpAcc;
    }
  public static boolean  lockEmployee(String empID){
        try {
            String query = "update tblAccount set StatusAcc=0 where UserID=?";
            Connection con = DBConnect.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            preSt.setString(1,empID);
            preSt.executeUpdate();


        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static boolean  lockCustomer(String empID){
        try {
            String query = "update tblAccount set StatusAcc=0 where UserID=?";
            Connection con = DBConnect.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            preSt.setString(1,empID);
            preSt.executeUpdate();


        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static boolean  unlockEmployee(String empID){
        try {
            String query = "update tblAccount set StatusAcc=1 where UserID=?";
            Connection con = DBConnect.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            preSt.setString(1,empID);
            preSt.executeUpdate();


        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static boolean  unlockCustomer(String empID){
        try {
            String query = "update tblAccount set StatusAcc=1 where UserID=?";
            Connection con = DBConnect.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            preSt.setString(1,empID);
            preSt.executeUpdate();


        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static ArrayList<Account> getListCusAccount() {
        ArrayList<Account> listCusAcc;
        try {

            String query = "select acc.Username,acc.UserID,acc.StatusAcc,cus.FirstnameCus as firstname,cus.LastnameCus as lastname,cus.PhoneCus as phone,acc.Email from tblAccount acc\n" +
                    "join tblCustomer cus on cus.CustomerID=acc.UserID";


            Connection con = DBConnect.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            ResultSet rs=preSt.executeQuery();
            listCusAcc=new ArrayList<>();
            while(rs.next()){
                String username = rs.getString(1);
                String userID = rs.getString(2);
                int status=rs.getInt(3);

                String firstname = rs.getString(4);
                String lastname = rs.getString(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
                Account newAcc=new Account( username,  userID,  firstname,  lastname,  phone,  email,  status);
                listCusAcc.add(newAcc);
            }
            con.close();
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
        return listCusAcc;
    }
    public static void main(String[] args) {
//        User user=login("khoavl", "123456789");
//        System.out.println(user);
        for (Account ac: getListCusAccount()
             ) {
            System.out.println(ac);
        }

      // addEmp("E0002","Nguyen","Quang","Huế","0123456789","QuangE2","123456789","Quang@email.com");
    }
}
