package SimplonClone.services.user;

import SimplonClone.Controllers.StateController;
import SimplonClone.Models.User.ApprenantModel;
import SimplonClone.services.Promo;

import java.util.HashMap;

public class Apprenant {
    public static HashMap<String, ApprenantModel> apprenants = new HashMap<>();
    public static HashMap<Integer, ApprenantModel> apprenantsById = new HashMap<>();
    public static HashMap<Integer, ApprenantModel> apprenantsByPromoId = new HashMap<>();
    public static int newApprenantId = 1;

    public static boolean create(int id) {

        System.out.println("Pour créer un compte Apprenant,\nremplissez les champs suivants :");

        String firstName = StateController.getInputString("Entrer le prenom:");
        String lastName = StateController.getInputString("Entrer le nom :");
        String email = StateController.getInputString("Entrer l'email :");
        String password = StateController.getInputString("Entrer le password :");
        ApprenantModel apprenant = new ApprenantModel(id, firstName, lastName, email, password);
        apprenants.put(email, apprenant);
        apprenantsById.put(id, apprenant);

        if (apprenants.get(email) == null) {
            System.out.println("La compte apprenant n'a pas été créée!");
            return false;
        }
        System.out.println("compte apprenant créée avec succès");
        return true;

    }

    public static boolean asignToPromo() {

        System.out.println("-------------------------");
        System.out.println("-  Liste des Apprenants  -");
        System.out.println("-------------------------");
        apprenants.forEach(
                (index, objet) -> System.out.println(objet.getId() + " : " + objet.getFirstName() + " " + objet.getLastName())
        );
        System.out.println("------------------------------------");
        int apprenantChose = StateController.getInputInt("Choiser le numero d'apprenant");
        // clear console here
        System.out.println("----------------------");
        System.out.println("-  Liste des promos  -");
        System.out.println("----------------------");
        Promo.promos.forEach(
                (index, objet) -> System.out.println(objet.getId() + " : " + objet.getName())
        );
        System.out.println("------------------------------------");
        int promoChose = StateController.getInputInt("Choiser le numero de la promo");
        //clear console here
        ApprenantModel apprenant = getApprenantById(apprenantChose);
        System.out.println(apprenant);
        if (apprenant.setPromoId(promoChose)) {

            System.out.println("La promo est attribuée au compte Apprenant avec succès");
            return true;
        }

        System.out.println("L'opération n'a pas fonctionné");
        return false;
    }

    public static ApprenantModel getApprenantById(int id) {

        return apprenantsById.get(id);
    }
}
