package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class PetShopDB {
   private static String username="sa",
           password="123456789",
           databaseName="PetShopDB";

   public static Connection getConnection () throws SQLException, ClassNotFoundException {
       String url="jdbc:sqlserver://localhost:1433;"+ "databaseName="+ databaseName+";encrypt=false";
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       System.out.println("Kết nối database");
       return DriverManager.getConnection(url,username,password);
   }

    public static void main(String[] args) {
        try {
            Connection connection= getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
//gaga
//gaga2