package SimplonClone;

import java.util.Scanner;

public class Auth {

    private static Person user;

    public static Person getUser() {
        return user;
    }
    public static void setUser(Person user) {
        Auth.user = user;
    }

    public static Person authentication() {

        System.out.println("Authentication form");
        System.out.println("-------------------\n");
        System.out.println("Enter Your Email : ");
        Scanner input = new Scanner(System.in);
        String email = input.nextLine();
        System.out.println("Enter Your Password : ");
        String password = input.nextLine();

        user = State.getUserByEmail(email);
        System.out.println(user);

        if (user == null || !user.verifyPassword(password)) {

            System.out.println("Email or password incorrect!");
            authentication();
        }
        System.out.println("Welcome " + user.getFirstName() + " " + user.getLastName());

        switch (user.getRole()) {
            case APPRENANT -> Menu.apprenantMenu();
            case FORMATEUR -> {
                Menu.formateurMenu();
            }
            default -> Menu.adminMenu();
        }


        return user;
    }

    public static boolean logout() {
        setUser(null);
        Main.setUser(null);
        Main.setProgramOn(false);
//        todo: remove admin when logged out

        return true;
    }
}
