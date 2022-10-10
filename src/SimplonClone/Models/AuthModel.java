package SimplonClone.Models;

import SimplonClone.Controllers.StateController;
import SimplonClone.Models.User.PersonModel;
import SimplonClone.databses.ConnectionMysql;
//import jdk.internal.icu.text.UnicodeSet;

import java.sql.Connection;

public class AuthModel extends ConnectionMysql {

    private static PersonModel user;
    public static Connection conn = ConnectionMysql.conn;

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
