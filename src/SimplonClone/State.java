package SimplonClone;

import java.util.HashMap;
import java.util.Scanner;

public class State {
    static HashMap<String, Promo> promos = new HashMap<>();
    static HashMap<String, Formateur> formateurs = new HashMap<>();
    static HashMap<Integer, Formateur> formateursById = new HashMap<>();
    static HashMap<String, Apprenant> apprenants = new HashMap<>();
    static HashMap<Integer, Apprenant> apprenantsById = new HashMap<>();
    static HashMap<String, Brief> briefs = new HashMap<>();
    static HashMap<Integer, Brief> briefById = new HashMap<>();
    static HashMap<Integer, Notification> notifications = new HashMap<>();
    private static  HashMap<String, Person> userByEmail;
    private static int newPromoId = 1;
    private static int newFormateurId = 1;
    private static int newApprenantId = 1;
    private static int newBriefId = 1;
    private static int newNotificationId = 1;

    public static void autoload(){

        userByEmail = new HashMap<>();
//        userByEmail.put("abdel@gmail.com", new Person(1, 1, "abdelghafour ","belkhoukh", "abdel@gmail.com", "123456", Role.APPRENANT));
//        userByEmail.put("belkhoukh@gmail.com", new Person(2, 1, "abdelghafour ", "belkhoukh", "belkhoukh@gmail.com", "123456", Role.FORMATEUR));
        userByEmail.put("belkhoukh16", new Person(3, 1, "abdelghafour", "belkhoukh", "belkhoukh@gmail.com", "123456", Role.ADMIN));

    }

    public static Person getUserByEmail(String email) {
        Person apprenant = apprenants.get(email);
        Person formateur = formateurs.get(email);
        Person admin = userByEmail.get(email);

        if (apprenant != null){

            return apprenant ;
        }
        if (formateur != null) {

            return formateur;
        }
        if ( admin != null){

            return admin;
        }

        return null;
    }



    // Commands methods

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

    public static void action(int chose, Role role) {
        switch (role) {
            case ADMIN -> {
                switch (chose) {
                    case 1 -> {
                        Promo.create(newPromoId);
                        newPromoId++;
                    }
                    case 2 -> {
                        Apprenant.create(newApprenantId);
                        newApprenantId++;
                    }
                    case 3 -> {
                        Formateur.create(newFormateurId);
                        newFormateurId++;
                    }
                    case 4 -> Formateur.asignToPromo();
                    case 5 -> Auth.logout();
                    default -> System.out.println("Ce choix n'est existe pas!!!");
                }
            }
                case FORMATEUR -> {
                    switch (chose) {
                        case 1 -> {
                            Brief.createBrief(newBriefId);
                            newBriefId++;
                        }
                        case 2 -> Apprenant.asignToPromo();
                        case 3 -> {
                            Brief.asignToPromo(newNotificationId, Auth.getUser());
                            newNotificationId++;
                        }
                        case 4 -> Auth.logout();
                        default -> System.out.println("Ce choix n'est existe pas!!!");
                    }
            }
            case APPRENANT -> {
                switch (chose) {
                    case 1 -> Brief.showBriefs(Auth.getUser().getPromoId());
                    case 2 -> Notification.getEmail(Auth.getUser().getPromoId());
                    case 3 -> Auth.logout();
                    default -> System.out.println("Ce choix n'est existe pas!!!");
                }
            }
        }
    }

}
