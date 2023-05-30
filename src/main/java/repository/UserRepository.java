package repository;

import config.DBConnect;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public static int register(User user) {
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement("insert into tblUser values(?,?,?,?,?,?,?,?)");
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getUserPass());
            stmt.setString(3, user.getUserFullName());
            stmt.setInt(4, user.getUserAge());
            stmt.setString(5, user.getUserEmail());
            stmt.setString(6, user.getUserPhone());
            stmt.setString(7, user.getUserAdress());
            stmt.setString(8, user.getUserRole());
            return stmt.executeUpdate(); //tra ve so hang bi anh huong?

        } catch (Exception e) {
            System.out.println("Loi Database method register trong UserRepository");
            return 0;
        }
    }

    public static User login(String username, String password) {
        User user=null;
        try {
            String query = "Select * from tblUser where UserName=? and UserPass=?";
            Connection con = DBConnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1,username );
            stmt.setString(2,password );
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                String userName=results.getString(1);
                String userPass=results.getString(2);
                String userFullName=results.getString(3);
                int userAge=results.getInt(4);
                String userEmail=results.getString(5);
                String userPhone=results.getString(6);
                String userAdress=results.getString(7);
                String role=results.getString(8);
                user=new User( userName,  userPass,  userFullName,  userAge, userEmail,  userPhone,  userAdress,role);
            }

        } catch (Exception e) {
            System.err.println("Loi Database method login trong UserRepository ");
        }
        return user;

    }
    public static void main(String[] args) {
//        User user=login("khoavl", "123456789");
//        System.out.println(user);
    }
}
