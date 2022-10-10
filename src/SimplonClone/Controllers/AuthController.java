package SimplonClone.Controllers;

import SimplonClone.Models.User.PersonModel;
import SimplonClone.servicesDB.Auth;

public class AuthController {
//    public static PersonModel authentication() {
//
//        return Auth.authentication();
//    }

    public static void login() {
        Auth.login();

    }
}
