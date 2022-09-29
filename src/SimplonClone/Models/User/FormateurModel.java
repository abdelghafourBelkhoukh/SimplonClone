package SimplonClone.Models.User;

import SimplonClone.Models.RoleModel;

public class FormateurModel extends PersonModel {

    public FormateurModel(int id, String firstName, String lastName, String Email, String password) {
        super( id, -1, firstName, lastName, Email, password, RoleModel.FORMATEUR);
    }

}
