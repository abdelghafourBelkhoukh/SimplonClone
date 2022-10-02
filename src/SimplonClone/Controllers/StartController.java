package SimplonClone.Controllers;

import SimplonClone.Models.MenuModel;
import SimplonClone.Models.RoleModel;
import SimplonClone.Models.User.PersonModel;
import SimplonClone.databses.ConnectionMysql;

public class StartController {
    public static PersonModel user;
    public static boolean programOn = true;
    public static RoleModel role;

    public static void start() {

        ConnectionMysql db = new ConnectionMysql();
        db.connect();

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
