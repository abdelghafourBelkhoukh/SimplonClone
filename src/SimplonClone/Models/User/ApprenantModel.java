package SimplonClone.Models.User;

import SimplonClone.Models.RoleModel;

public class ApprenantModel extends PersonModel {

    public ApprenantModel(int id, String firstName, String lastName, String Email, String password) {
        super( id, -1, firstName, lastName, Email, password, RoleModel.APPRENANT);
    }

}
