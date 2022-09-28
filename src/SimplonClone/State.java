package SimplonClone;

import java.util.HashMap;
import java.util.Scanner;

public class State {
    static HashMap<String, Promo> promos = new HashMap<String, Promo>();
    static HashMap<String, Formateur> formateurs = new HashMap<String, Formateur>();
    static HashMap<Integer, Formateur> formateursById = new HashMap<Integer, Formateur>();
    static HashMap<String, Apprenant> apprenants = new HashMap<String, Apprenant>();
    static HashMap<Integer, Apprenant> apprenantsById = new HashMap<Integer, Apprenant>();
    static HashMap<String, Brief> briefs = new HashMap<String, Brief>();
    private static  HashMap<String, Person> userByEmail;
    private static int newPromoId = 1;
    private static int newFormateurId = 1;
    private static int newApprenantId = 1;
    private static int newBriefId = 1;

    public static void autoload(){

        userByEmail = new HashMap<String, Person>();
        userByEmail.put("abdel@gmail.com", new Person(1, 1, "abdelghafour ","belkhoukh", "abdel@gmail.com", "123456", Role.APPRENANT));
        userByEmail.put("belkhoukh@gmail.com", new Person(2, 1, "abdelghafour ", "belkhoukh", "belkhoukh@gmail.com", "123456", Role.FORMATEUR));
        userByEmail.put("belkhoukh16@gmail.com", new Person(3, 1, "abdelghafour", "belkhoukh", "belkhoukh@gmail.com", "123456", Role.ADMIN));

    }

    public static Person getUserByEmail(String email) {
        return userByEmail.get(email);
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
                    case 5 -> Action.logout();
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
                        case 3 -> Action.logout();
                        default -> System.out.println("Ce choix n'est existe pas!!!");
                    }
            }
            case APPRENANT -> {
                switch (chose) {
                    case 1 -> Action.showBriefs(Auth.getUser().getPromoId());
                    case 2 -> Action.logout();
                    default -> System.out.println("Ce choix n'est existe pas!!!");
                }
            }
        }
    }

}
