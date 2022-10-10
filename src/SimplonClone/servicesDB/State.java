package SimplonClone.servicesDB;

import SimplonClone.Controllers.BriefController;
import SimplonClone.Controllers.NotificationController;
import SimplonClone.Controllers.PromoController;
import SimplonClone.Controllers.StateController;
import SimplonClone.Controllers.User.ApprenantController;
import SimplonClone.Controllers.User.FormateurController;
import SimplonClone.Models.AuthModel;
import SimplonClone.Models.RoleModel;
import SimplonClone.Models.User.PersonModel;
import SimplonClone.servicesDB.Promo;
import SimplonClone.servicesDB.Brief;
import SimplonClone.servicesDB.user.Apprenant;
import SimplonClone.servicesDB.user.Formateur;

import java.util.HashMap;
import java.util.Scanner;

public class State {
    
    public static PersonModel getUserByEmail(String email) {
//        PersonModel apprenant = Apprenant.apprenants.get(email);
//        PersonModel formateur = Formateur.formateurs.get(email);
        PersonModel admin = StateController.userByEmail.get(email);

//        if (apprenant != null) {
//
//            return apprenant;
//        }
//        if (formateur != null) {
//
//            return formateur;
//        }
//        if (admin != null) {
//
//            return admin;
//        }

        return null;
    }

    public static String getInputString(String message) {
        System.out.println(message);
        Scanner input = new Scanner(System.in);

        return input.nextLine();
    }

    public static int getInputInt(String message) {
        System.out.println(message);
        Scanner input = new Scanner(System.in);
        int inputValue = input.nextInt();

        return inputValue;
    }

    public static int getInputInt() {
        Scanner input = new Scanner(System.in);
        int inputValue = input.nextInt();

        return inputValue;
    }

    public static void action(int chose, RoleModel role) {
        switch (role) {
            case ADMIN -> {
                switch (chose) {
                    case 1 -> Promo.create();
                    case 2 -> Apprenant.create();
                    case 3 -> Formateur.create();
                    case 4 -> Formateur.asignToPromo();
                    case 5 -> Auth.logout();
                    default -> System.out.println("Ce choix n'est existe pas!!!");
                }
            }
            case FORMATEUR -> {
                switch (chose) {
                    case 1 -> Brief.createBrief();
                    case 2 -> Apprenant.asignToPromo();
                    case 3 -> Brief.asignToPromo();
                    case 4 -> Auth.logout();
                    default -> System.out.println("Ce choix n'est existe pas!!!");
                }
            }
            case APPRENANT -> {
                switch (chose) {
                    case 1 -> BriefController.showBriefs(AuthModel.getUser().getPromoId());
                    case 2 -> NotificationController.getEmail(AuthModel.getUser().getPromoId());
                    case 3 -> AuthModel.logout();
                    default -> System.out.println("Ce choix n'est existe pas!!!");
                }
            }
        }
    }





    public static void load() {
    }
}
