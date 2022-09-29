package SimplonClone.Models;

import SimplonClone.Controllers.StateController;
import SimplonClone.Models.User.PersonModel;

public class AuthModel {

    private static PersonModel user;

    public static PersonModel getUser() {

        return user;
    }
    public static void setUser(PersonModel user) {
        AuthModel.user = user;
    }

    public static boolean logout() {
        setUser(null);
        StateController.setUser(null);
        StateController.setProgramOn(false);

        return true;
    }
}
