package SimplonClone.Controllers.User;

import SimplonClone.services.user.Apprenant;

public class ApprenantController {

    public static boolean create(int id) {

        return Apprenant.create(id);
    }

    public static boolean asignToPromo() {

        return Apprenant.asignToPromo();
    }

}
