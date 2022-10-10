package SimplonClone.services;

import SimplonClone.Controllers.StateController;
import SimplonClone.Models.PromoModel;

import java.util.HashMap;

public class Promo {
    public static HashMap<String, PromoModel> promos = new HashMap<>();
    public static int newPromoId = 1;

    public static boolean create(int id) {
        String promoName = StateController.getInputString("Enter le nom de la promo :");
        int promoYear = StateController.getInputInt("Enter l'annee de la promo :");
        promos.put(promoName, new PromoModel(id, promoName, promoYear));

        if (promos.get(promoName) == null) {
            System.out.println("La promo n'a pas été créée!");
            return false;
        }

        System.out.println("Promo créée avec succès");

        return true;
    }
}
