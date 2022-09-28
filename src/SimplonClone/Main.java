package SimplonClone;


public class Main {


    private static Person user;


    private static boolean programOn = true;
    private static Role role;
    public static void main(String[] args) {

        login();
        while (programOn){

            while (user != null){
            int orderChose = State.getInputInt();
            State.action(orderChose, role);
                switch (role) {
                    case APPRENANT -> Menu.apprenantMenu();
                    case FORMATEUR -> Menu.formateurMenu();
                    default -> Menu.adminMenu();
                }
            }

            login();
            programOn = true;
        }

    }

    public static void login(){
        Menu.welcome();
        State.autoload();
        user = Auth.authentication();
        role = user.getRole();

    }
    public static void setUser(Person user) {
        Main.user = user;
    }

    public static void setProgramOn(boolean programOn) {
        Main.programOn = programOn;
    }

}
