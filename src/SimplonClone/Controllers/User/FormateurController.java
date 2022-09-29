package SimplonClone.Controllers.User;

import SimplonClone.services.user.Formateur;

public class FormateurController {

    public static boolean create(int newFormateurId) {

        return Formateur.create(newFormateurId);
    }

    public static boolean asignToPromo() {

        return Formateur.asignToPromo();
    }

}
