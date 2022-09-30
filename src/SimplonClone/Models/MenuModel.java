package SimplonClone.Models;

import SimplonClone.Controllers.StartController;

public class MenuModel {
    public static void welcome() {
        System.out.println("Welcome to Maghreb Coding school");
        System.out.println("********************************\n");
    }

    public static void apprenantMenu() {
        System.out.println("------------------");
        System.out.println("  Apprenant Menu");
        System.out.println("------------------");
        System.out.println("Pour voir les briefs : 1");
        System.out.println("Notifications : 2");
        System.out.println("Logout : 3");
    }

    public static void formateurMenu() {
        System.out.println("------------------");
        System.out.println("  Formateur Menu");
        System.out.println("------------------");
        System.out.println("Cree un brief : 1");
        System.out.println("ajouter un apprenant a une promos : 2");
        System.out.println("ajouter un brief au promo : 3");
        System.out.println("Logout : 4");
    }

    public static void adminMenu() {
        System.out.println("------------------");
        System.out.println("    Admin Menu");
        System.out.println("------------------");
        System.out.println("Cree une promos : 1");
        System.out.println("Cree un compte apprenant : 2");
        System.out.println("Cree un compte formateur : 3");
        System.out.println("attribue une promo à un formateur : 4");
        System.out.println("Logout : 5");
    }

    public static void menuByRole() {
        switch (StartController.role) {
            case APPRENANT -> apprenantMenu();
            case FORMATEUR -> formateurMenu();
            default -> adminMenu();
        }

    }
}
