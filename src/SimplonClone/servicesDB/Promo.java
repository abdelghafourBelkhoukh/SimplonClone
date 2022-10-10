package SimplonClone.servicesDB;

import SimplonClone.Controllers.StateController;
import SimplonClone.Models.PromoModel;
import SimplonClone.databses.ConnectionMysql;

import java.sql.*;

public class Promo {
    static Connection conn = ConnectionMysql.conn;
    static int result;
    static Statement statement;

    public static boolean create() {
        String promoName = StateController.getInputString("Enter le nom de la promo :");
        int promoYear = StateController.getInputInt("Enter l'annee de la promo :");

        String sql = "INSERT INTO promos(name, year) VALUES ('"+promoName+"','"+promoYear+"')";
        try {
            statement = conn.createStatement();
            result = statement.executeUpdate(sql);
            if (result == 0) {
                System.out.println("La promo n'a pas été créée!");
                return false;
            }
            System.out.println("Promo créée avec succès");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
