package SimplonClone.services;

import SimplonClone.Controllers.StateController;
import SimplonClone.Models.PromoModel;
import SimplonClone.Models.StateModel;

public class Promo {
    public static boolean create(int id) {
        String promoName = StateController.getInputString("Enter le nom de la promo :");
        int promoYear = StateController.getInputInt("Enter l'annee de la promo :");
        StateModel.promos.put(promoName, new PromoModel(id, promoName, promoYear));

        if (StateModel.promos.get(promoName) == null) {
            System.out.println("La promo n'a pas été créée!");
            return false;
        }

        System.out.println("Promo créée avec succès");

        return true;
    }
}
