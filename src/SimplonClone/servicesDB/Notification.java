package SimplonClone.servicesDB;

import SimplonClone.Models.StateModel;

public class Notification {
    public static void getEmail(int promoId) {
        StateModel.notifications.forEach(
                (index, objet) -> {
                    if (objet.getPromoId() == promoId) {

                        System.out.println(objet.getMessage());
                        System.out.println("-------------------------------------------------------------------------------");
                    }
                }
        );
    }
}
