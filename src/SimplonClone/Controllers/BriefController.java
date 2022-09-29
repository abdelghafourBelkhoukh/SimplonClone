package SimplonClone.Controllers;

import SimplonClone.Models.BriefModel;
import SimplonClone.Models.User.PersonModel;
import SimplonClone.services.Brief;

public class BriefController {
    public static boolean createBrief(int id) {

        return Brief.createBrief(id);
    }

    public static boolean asignToPromo(int notificationId, PersonModel formateur) {

        return Brief.asignToPromo(notificationId, formateur);
    }
    public static boolean showBriefs(int promoId) {

        return Brief.showBriefs(promoId);
    }

    public static BriefModel getById(int id) {

        return Brief.getById(id);
    }
}
