package SimplonClone.servicesDB;

public class Notification {
    public static void getEmail(int promoId) {
        SimplonClone.services.Notification.notifications.forEach(
                (index, objet) -> {
                    if (objet.getPromoId() == promoId) {

                        System.out.println(objet.getMessage());
                        System.out.println("-------------------------------------------------------------------------------");
                    }
                }
        );
    }
}
