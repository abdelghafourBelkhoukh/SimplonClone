package SimplonClone.servicesDB.user;

import SimplonClone.Controllers.StateController;
import SimplonClone.Models.User.FormateurModel;
import SimplonClone.databses.ConnectionMysql;
import SimplonClone.servicesDB.Promo;

import java.sql.*;
import java.util.ArrayList;

public class Formateur {
    static Connection conn = ConnectionMysql.conn;
    static Statement statement;
    static PreparedStatement statement1 = null;
    static int result;
    static String formateur = "";
    public static boolean create() {
        System.out.println("Pour créer un compte formateur,\nremplissez les champs suivants :");
        String firstName = StateController.getInputString("Entrer le prenom:");
        String lastName = StateController.getInputString("Entrer le nom");
        String email = StateController.getInputString("Entrer l'email :");
        String password = StateController.getInputString("Entrer le password :");

        String sql = "INSERT INTO users(firstname, lastname, email, password, roleId) VALUES ('"+firstName+"','"+lastName+"','"+email+"','"+password+"', 'FORMATEUR')";
        try {
            statement = conn.createStatement();
            result = statement.executeUpdate(sql);
            if (result == 0) {
                System.out.println("Le compte du formateur n'a pas été créée!");
                return false;
            }
            System.out.println("le compte du formateur créée avec succès");
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }


        return true;
    }

    public static boolean asignToPromo() {

        System.out.println("------------------------------------");
        int formateurChose = StateController.getInputInt("Choiser ID du formateur");

        System.out.println("------------------------------------");
        int promoChose = StateController.getInputInt("Choiser ID du promos");

        String sql = "UPDATE users SET promoId = " + promoChose + " WHERE id =" + formateurChose;
        try {
            statement = conn.createStatement();
            int rs = statement.executeUpdate(sql);
                if(rs == 0) {
                     System.out.println("L'opération n'a pas fonctionné");
                    return false;
                }

            System.out.println("La promo est attribuée au compte formateur avec succès");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static FormateurModel getFormateurById(int id) {

        return SimplonClone.services.user.Formateur.formateursById.get(id);
    }
}
