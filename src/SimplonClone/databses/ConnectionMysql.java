package SimplonClone.databses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysql {

   private final String url = "jdbc:postgresql://localhost/cloneSimplon";
   private final String user = "postgres";
   private final String password = "123456";

   /**
    * Connect to the PostgreSQL database
    *
    * @return a Connection object
    */
   public Connection connect() {
      Connection conn = null;
      try {
         conn = DriverManager.getConnection(url, user, password);
         if (conn == null) {

            System.out.println("Connected to the PostgreSQL server Failed");
            return conn;
         }
            System.out.println("Connected to the PostgreSQL server successfully.");

      } catch (SQLException e) {
         System.out.println(e.getMessage());
      }

      return conn;
   }



}



































//    } private final String url = "jdbc:postgresql://localhost/dvdrental";
//    private final String user = "postgres";
//    private final String password = "<add your password>";
//
//    public ConnectionMysql(){
//        ConnectionMysql app = new ConnectionMysql();
//        app.connect();
//    }
//
//    public Connection connect() {
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(url, user, password);
//            System.out.println("Connected to the PostgreSQL server successfully.");
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return conn;
//    }


