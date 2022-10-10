package SimplonClone.servicesDB;


import SimplonClone.Controllers.StartController;
import SimplonClone.Controllers.StateController;
import SimplonClone.Models.AuthModel;
import SimplonClone.Models.MenuModel;
import SimplonClone.Models.RoleModel;
import SimplonClone.Models.User.PersonModel;
import SimplonClone.databses.ConnectionMysql;

import javax.management.relation.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class Auth extends ConnectionMysql {

    public static Connection conn = ConnectionMysql.conn;
    private static PreparedStatement statement = null;
    static String sql = null;
    static ResultSet result;
    static RoleModel roleDB;
    static int promoIdDB = -1;

    public static RoleModel authentication() {
        System.out.println("Authentication form");
        System.out.println("-------------------\n");
        System.out.println("Enter Your Email : ");
        Scanner input = new Scanner(System.in);
        String email = input.nextLine();
        System.out.println("Enter Your Password : ");
        String password = input.nextLine();

        sql = "SELECT id, firstname, lastname, email, password, promoId, roleId FROM users WHERE email = '" + email + "' ";
        try {

            statement = conn.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()){
                String emailDB = result.getString("email");
                String passwordDB  = result.getString("password");

                if (emailDB == null || passwordDB == null) {

                    System.out.println("Email or password incorrect!");
                    authentication();
                }
                String firstnameDB  = result.getString("firstname");
                String lastnameDB  = result.getString("lastname");
                if (result.getString("promoId") != null) {

                promoIdDB  = Integer.parseInt(result.getString("promoId"));
                }
                int idDB  = Integer.parseInt(result.getString("id"));
                roleDB = RoleModel.valueOf(result.getString("roleId"));

                System.out.println("welcome " + firstnameDB +" "+ lastnameDB);

                StateController.userByEmail = new HashMap<>();
                PersonModel user = new PersonModel(idDB, promoIdDB, firstnameDB, lastnameDB, email, passwordDB, roleDB);
//                StateController.userByEmail.put(emailDB, user);
//                AuthModel.setUser(user);
                StartController.role = roleDB;
                StartController.user = user;
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return roleDB;

    }

    public static void login() {

        switch (authentication()) {
            case APPRENANT -> MenuModel.apprenantMenu();
            case FORMATEUR -> MenuModel.formateurMenu();
            default -> MenuModel.adminMenu();
        }
    }

    public static void logout() {
        StartController.user = null;
        StateController.setProgramOn(false);
    }
}
