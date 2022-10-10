package SimplonClone.servicesDB.user;

import SimplonClone.Controllers.StateController;
import SimplonClone.Models.User.ApprenantModel;
import SimplonClone.databses.ConnectionMysql;
import SimplonClone.services.Promo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Apprenant {
    static Connection conn = ConnectionMysql.conn;
    static Statement statement;
    static int result;
    public static boolean create() {

        System.out.println("Pour créer un compte Apprenant,\nremplissez les champs suivants :");

        String firstName = StateController.getInputString("Entrer le prenom:");
        String lastName = StateController.getInputString("Entrer le nom :");
        String email = StateController.getInputString("Entrer l'email :");
        String password = StateController.getInputString("Entrer le password :");
        String sql = "INSERT INTO users(firstname, lastname, email, password, roleId) VALUES ('"+firstName+"','"+lastName+"','"+email+"','"+password+"', 'APPRENANT')";
        try {
            statement = conn.createStatement();
            result = statement.executeUpdate(sql);
            if (result == 0) {
                System.out.println("La compte apprenant n'a pas été créée!");
                return false;
            }
            System.out.println("compte apprenant créée avec succès");
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }


        return true;

    }

    public static boolean asignToPromo() {

        System.out.println("------------------------------------");
        int apprenantChose = StateController.getInputInt("Choiser ID du Apprenant");

        System.out.println("------------------------------------");
        int promoChose = StateController.getInputInt("Choiser ID du promos");

        String sql = "UPDATE users SET promoId = " + promoChose + " WHERE id =" + apprenantChose ;
        try {
            statement = conn.createStatement();
            int rs = statement.executeUpdate(sql);
            if(rs == 0) {
                System.out.println("L'opération n'a pas fonctionné");
                return false;
            }

            System.out.println("La promo est attribuée au compte Apprenant avec succès");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ApprenantModel getApprenantById(int id) {

        return SimplonClone.services.user.Apprenant.apprenantsById.get(id);
    }
}
