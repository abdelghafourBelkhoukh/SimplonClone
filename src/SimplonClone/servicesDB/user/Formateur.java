package SimplonClone.servicesDB.user;

import SimplonClone.Controllers.StateController;
import SimplonClone.Models.StateModel;
import SimplonClone.Models.User.FormateurModel;

public class Formateur {
    public static boolean create(int newFormateurId) {
        System.out.println("Pour créer un compte formateur,\nremplissez les champs suivants :");
        String firstName = StateController.getInputString("Entrer le prenom:");
        String lastName = StateController.getInputString("Entrer le nom");
        String email = StateController.getInputString("Entrer l'email :");
//        String promoName = State.getInputString("Entrer le nom de la promo :");
//        Promo promo = getPromoByName(promoName);
//        int promoId = promo.getId();
        String password = StateController.getInputString("Entrer le password :");

        FormateurModel formateur = new FormateurModel(newFormateurId, firstName, lastName, email, password);
        StateModel.formateurs.put(email, formateur);
        StateModel.formateursById.put(newFormateurId, formateur);

        if (StateModel.formateurs.get(email) == null) {
            System.out.println("La compte formateur n'a pas été créée!");
            return false;
        }
        System.out.println("compte formateur créée avec succès");
        return true;
    }

    public static boolean asignToPromo() {
        System.out.println("-------------------------");
        System.out.println("-  Liste des formateur  -");
        System.out.println("-------------------------");
        StateModel.formateurs.forEach(
                (index, objet) -> System.out.println(objet.getId() + " : " + objet.getFirstName() + " " + objet.getLastName())
        );
        System.out.println("------------------------------------");
        int formateurChose = StateController.getInputInt("Choiser le numero du formateur");
        // clear console here
        System.out.println("----------------------");
        System.out.println("-  Liste des promos  -");
        System.out.println("----------------------");
        StateModel.promos.forEach(
                (index, objet) -> System.out.println(objet.getId() + " : " + objet.getName())
        );
        System.out.println("------------------------------------");
        int promoChose = StateController.getInputInt("Choiser le numero du formateur");
        //clear console here
        FormateurModel formateur = getFormateurById(formateurChose);

        if (formateur.setPromoId(promoChose)) {

            System.out.println("La promo est attribuée au compte formateur avec succès");
            return true;
        }

        System.out.println("L'opération n'a pas fonctionné");
        return false;
    }

    public static FormateurModel getFormateurById(int id) {

        return StateModel.formateursById.get(id);
    }
}
