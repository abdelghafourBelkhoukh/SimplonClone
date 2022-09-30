package SimplonClone.Controllers;

import SimplonClone.Models.MenuModel;
import SimplonClone.Models.RoleModel;
import SimplonClone.Models.User.PersonModel;

public class StartController {
    public static PersonModel user;
    public static boolean programOn = true;
    public static RoleModel role;

    public static void start() {
        MenuModel.welcome();
        AuthController.login();

        while (programOn) {

            while (user != null) {
                int orderChose = StateController.getInputInt();
                StateController.action(orderChose, role);
                MenuModel.menuByRole();
            }

            AuthController.login();
            programOn = true;
        }
    }
}
