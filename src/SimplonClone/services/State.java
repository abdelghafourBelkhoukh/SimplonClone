package SimplonClone.services;

import SimplonClone.Controllers.BriefController;
import SimplonClone.Controllers.NotificationController;
import SimplonClone.Controllers.PromoController;
import SimplonClone.Controllers.StateController;
import SimplonClone.Controllers.User.ApprenantController;
import SimplonClone.Controllers.User.FormateurController;
import SimplonClone.Models.AuthModel;
import SimplonClone.Models.RoleModel;
import SimplonClone.Models.User.PersonModel;
import SimplonClone.services.user.Apprenant;
import SimplonClone.services.user.Formateur;

import java.util.HashMap;
import java.util.Scanner;

public class State {
    public static void load() {

        StateController.userByEmail = new HashMap<>();
        StateController.userByEmail.put("admin", new PersonModel(3, 1, "abdelghafour", "belkhoukh", "belkhoukh@gmail.com", "admin", RoleModel.ADMIN));

    }

    public static PersonModel getUserByEmail(String email) {
        PersonModel apprenant = Apprenant.apprenants.get(email);
        PersonModel formateur = Formateur.formateurs.get(email);
        PersonModel admin = StateController.userByEmail.get(email);

        if (apprenant != null) {

            return apprenant;
        }
        if (formateur != null) {

            return formateur;
        }
        if (admin != null) {

            return admin;
        }

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
                    case 1 -> {
                        PromoController.create(Promo.newPromoId);
                        Promo.newPromoId++;
                    }
                    case 2 -> {
                        ApprenantController.create(Apprenant.newApprenantId);
                        Apprenant.newApprenantId++;
                    }
                    case 3 -> {
                        FormateurController.create(Formateur.newFormateurId);
                        Formateur.newFormateurId++;
                    }
                    case 4 -> FormateurController.asignToPromo();
                    case 5 -> AuthModel.logout();
                    default -> System.out.println("Ce choix n'est existe pas!!!");
                }
            }
            case FORMATEUR -> {
                switch (chose) {
                    case 1 -> {
                        BriefController.createBrief(Brief.newBriefId);
                        Brief.newBriefId++;
                    }
                    case 2 -> ApprenantController.asignToPromo();
                    case 3 -> {
                        BriefController.asignToPromo(Notification.newNotificationId, AuthModel.getUser());
                        Notification.newNotificationId++;
                    }
                    case 4 -> AuthModel.logout();
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
}
