package SimplonClone.Controllers;

import SimplonClone.Models.User.PersonModel;
import SimplonClone.View.Main;
import SimplonClone.services.Auth;

public class AuthController {
    public static PersonModel authentication() {

        return Auth.authentication();
    }

    public static void login(){
        Auth.login();

    }
}
