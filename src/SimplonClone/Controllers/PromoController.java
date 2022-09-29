package SimplonClone.Controllers;


import SimplonClone.services.Promo;

public class PromoController {
    public static boolean create(int id) {
        return Promo.create(id);
    }
}
