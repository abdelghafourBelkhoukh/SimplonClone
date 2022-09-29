package SimplonClone.Models.User;

import SimplonClone.Models.RoleModel;

public class AdministrateurModel extends PersonModel {

    public AdministrateurModel(int id, int promoId, String firstName, String lastName, String Email, String password, RoleModel role) {
        super( id, promoId, firstName, lastName, Email, password, role);
    }
}
