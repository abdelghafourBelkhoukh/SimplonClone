package SimplonClone.databses;

import java.sql.*;


// Infos BD
public class ConnectionMysql {
   final String url = "jdbc:mysql://localhost:3306/simplonclone";
   final String username = "root";
   final String password = "";
   public static Connection conn = null;
   static ConnectionMysql db;
   public static PreparedStatement stmt;

   // Connect BD a MYSQL
   public ConnectionMysql()
   {
      try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(url, username, password);

      }catch(Exception e)
      {
         System.out.println("error => " + e);
      }
   }

   public static  ConnectionMysql connect(){
      if (conn ==null){
         db = new ConnectionMysql();
      }
      return  db;
   }


}