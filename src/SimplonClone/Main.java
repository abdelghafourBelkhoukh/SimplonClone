package SimplonClone;


public class Main {
    public static void main(String[] args) {

        Menu.welcome();
        State.autoload();

        Person user = Auth.authentication();
        Role role = user.getRole();
        System.out.println(role);
        while (user != null){
        int orderChose = State.getInputInt();
        State.action(orderChose, role);
            switch (role) {
                case APPRENANT -> Menu.apprenantMenu();
                case FORMATEUR -> Menu.formateurMenu();
                default -> Menu.adminMenu();
            }
        }



    }

}