package repository;


import config.DBConnect;
import entity.Admin;
import entity.Customer;
import entity.Employee;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthenticationRepository {
    public static User Verify(String username, String password) {
        try {
            String query = "Select * from tblAccount where username=? and passwordAcc=?";
            Connection con = DBConnect.getConnection();
            PreparedStatement preSt = con.prepareStatement(query);
            preSt.setString(1, username);
            preSt.setString(2, password);
            ResultSet rs = preSt.executeQuery();
            if (rs.next()) {
                //Check getID of username to select role
                String userID = rs.getString(3);

                if (userID.startsWith("A")) {
                    query = "SELECT * from tblAdmin where AdminID=?";
                    preSt = con.prepareStatement(query);
                    preSt.setString(1, userID);
                    rs = preSt.executeQuery();
                    System.out.println(rs.next());
                    String firstname = rs.getString(2),
                            lastname = rs.getString(3),
                            address = rs.getString(4),
                            phone = rs.getString(5);
                    con.close();
                    Admin admin = new Admin(userID, firstname, lastname, address, phone);
                    return admin;

                } else if (userID.startsWith("E")) {
                    query = "SELECT * from tblEmployee where EmployeeID=?";
                    preSt = con.prepareStatement(query);
                    preSt.setString(1, userID);
                    rs = preSt.executeQuery();
                    rs.next();
                    String firstname = rs.getString(2),
                            lastname = rs.getString(3),
                            address = rs.getString(4),
                            phone = rs.getString(5);
                    con.close();
                    return new Employee(userID, firstname, lastname, address, phone);
                } else if (userID.startsWith("C")) {
                    query = "SELECT * from tblCustomer where CustomerID=?";
                    preSt = con.prepareStatement(query);
                    preSt.setString(1, userID);
                    rs = preSt.executeQuery();
                    rs.next();

                    String firstname = rs.getString(2),
                            lastname = rs.getString(3),
                            address = rs.getString(4),
                            phone = rs.getString(5);
                    con.close();
                    return new Customer(userID, firstname, lastname, address, phone);
                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ok");
        return null;
    }

    public static void main(String[] args) {
        //Test Verify
       System.out.println(Verify("khoanguvai","123456789"));
//        System.out.println(Verify("Khoangungoc","khoangungoc"));
//        System.out.println(Verify("QuangE","123456789"));

    }
}
