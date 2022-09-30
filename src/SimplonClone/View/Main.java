package SimplonClone.View;

import SimplonClone.Controllers.AuthController;
import SimplonClone.Controllers.StateController;
import SimplonClone.Models.MenuModel;
import SimplonClone.Models.RoleModel;
import SimplonClone.Models.User.PersonModel;
import SimplonClone.databses.ConnectionMysql;

public class Main {

    public static PersonModel user;
    public static boolean programOn = true;
    public static RoleModel role;
    public static void main(String[] args) {
        MenuModel.welcome();
        AuthController.login();

        while (programOn){

            while (user != null){
                int orderChose = StateController.getInputInt();
                StateController.action(orderChose, role);
                MenuModel.menuByRole();
            }

            AuthController.login();
            programOn = true;
        }

    }

//    public static void clearConsole() {
//        //
//    }


}
