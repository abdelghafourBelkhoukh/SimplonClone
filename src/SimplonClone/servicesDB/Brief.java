package SimplonClone.servicesDB;

import SimplonClone.Controllers.NotificationController;
import SimplonClone.Controllers.StartController;
import SimplonClone.Controllers.StateController;
import SimplonClone.Models.AuthModel;
import SimplonClone.Models.BriefModel;
import SimplonClone.Models.NotificationModel;
import SimplonClone.Models.User.PersonModel;
import SimplonClone.databses.ConnectionMysql;
import SimplonClone.services.Notification;
import SimplonClone.services.Promo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Brief {
    static Connection conn = ConnectionMysql.conn;
    static int result;
    static Statement statement;
    public static boolean createBrief() {

        System.out.println("Pour créer un brief,\nremplissez les champs suivants :");
        String title = StateController.getInputString("Entrer le titre");
        String description = StateController.getInputString("Entrer une description");
        PersonModel formateur = StartController.user;
        int formateurId = formateur.getId();

        String sql = "INSERT INTO briefs(title, description, formateurId) VALUES ('"+title+"','"+description+"','"+formateurId+"')";
        try {
            statement = conn.createStatement();
            result = statement.executeUpdate(sql);
            if (result == 0) {
                System.out.println("Brief not added");
                return false;
            }
            System.out.println("Brief added");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return true;
    }

    public static boolean asignToPromo() {

        System.out.println("------------------------------------");
        int briefChose = StateController.getInputInt("Choiser ID du brief");

        System.out.println("------------------------------------");
        int promoChose = StateController.getInputInt("Choiser ID du promos");

        String sql = "UPDATE briefs SET promoId = " + promoChose + " WHERE id =" + briefChose;
        try {
            statement = conn.createStatement();
            int rs = statement.executeUpdate(sql);
            if(rs == 0) {
                System.out.println("L'opération n'a pas fonctionné");

                return false;
            }

            System.out.println("Le brief est attribuée au promo avec succès");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public static boolean showBriefs(int promoId) {

        SimplonClone.services.Brief.briefs.forEach(
                (index, objet) -> {
                    if (objet.getPromoId() == promoId) {

                        System.out.println(objet.getId() + " : " + objet.getTitle());
                    }
                }
        );
        return true;
    }
    public static BriefModel getById(int id) {

        return SimplonClone.services.Brief.briefById.get(id);
    }

}
