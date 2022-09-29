package SimplonClone.Controllers;

import SimplonClone.Models.RoleModel;
import SimplonClone.Models.User.PersonModel;
import SimplonClone.View.Main;
import SimplonClone.services.State;

public class StateController {
    public static void load() {

        State.load();
    }

    public static PersonModel getUserByEmail(String email) {

        return State.getUserByEmail(email);
    }

    public static String getInputString(String message) {

        return State.getInputString(message);
    }

    public static int getInputInt(String message) {

        return State.getInputInt(message);
    }

    public static int getInputInt() {

        return State.getInputInt();
    }

    public static void action(int chose, RoleModel role) {

        State.action(chose, role);
    }

    public static void setUser(PersonModel user) {
        Main.user = user;
    }

    public static void setProgramOn(boolean programOn) {
        Main.programOn = programOn;
    }
}
