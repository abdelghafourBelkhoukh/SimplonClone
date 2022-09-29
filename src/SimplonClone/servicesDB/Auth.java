package SimplonClone.servicesDB;

import SimplonClone.Controllers.StateController;
import SimplonClone.Models.AuthModel;
import SimplonClone.Models.MenuModel;
import SimplonClone.Models.User.PersonModel;
import SimplonClone.View.Main;

import java.util.Scanner;

public class Auth {
    public static PersonModel authentication() {

        System.out.println("Authentication form");
        System.out.println("-------------------\n");
        System.out.println("Enter Your Email : ");
        Scanner input = new Scanner(System.in);
        String email = input.nextLine();
        System.out.println("Enter Your Password : ");
        String password = input.nextLine();

        AuthModel.setUser(StateController.getUserByEmail(email));
        System.out.println(AuthModel.getUser());

        if (AuthModel.getUser() == null || !AuthModel.getUser().verifyPassword(password)) {

            System.out.println("Email or password incorrect!");
            authentication();
        }
        System.out.println("Welcome " + AuthModel.getUser().getFirstName() + " " + AuthModel.getUser().getLastName());

        switch (AuthModel.getUser().getRole()) {
            case APPRENANT -> MenuModel.apprenantMenu();
            case FORMATEUR -> {
                MenuModel.formateurMenu();
            }
            default -> MenuModel.adminMenu();
        }


        return AuthModel.getUser();
    }

    public static void login(){
        StateController.load();
        StateController.setUser(authentication());
        Main.role = Main.user.getRole();

    }
}
