package SimplonClone.services;

import SimplonClone.Controllers.BriefController;
import SimplonClone.Controllers.NotificationController;
import SimplonClone.Controllers.StartController;
import SimplonClone.Controllers.StateController;
import SimplonClone.Models.AuthModel;
import SimplonClone.Models.BriefModel;
import SimplonClone.Models.NotificationModel;
import SimplonClone.Models.User.PersonModel;
import SimplonClone.services.user.Apprenant;

import java.util.HashMap;


public class Brief {
    public static HashMap<String, BriefModel> briefs = new HashMap<>();
    public static HashMap<Integer, BriefModel> briefById = new HashMap<>();
    public static int newBriefId = 1;

    public static boolean createBrief(int id) {

        System.out.println("Pour créer un brief,\nremplissez les champs suivants :");
        String title = StateController.getInputString("Entrer le titre");
        String description = StateController.getInputString("Entrer une description");
        PersonModel formateur = AuthModel.getUser();
        int formateurId = formateur.getId();
        BriefModel brief = new BriefModel(id, title, description, formateurId);
        briefs.put(title, brief);
        briefById.put(id, brief);
        if (briefs.get(title) != null) {
            System.out.println("Brief added");
            return true;
        }

        System.out.println("Brief not added");
        return false;
    }

    public static boolean asignToPromo(int notificationId, PersonModel formateur) {

        System.out.println("-------------------------");
        System.out.println("-  Liste des Briefs  -");
        System.out.println("-------------------------");
        briefs.forEach(
                (index, objet) -> {
                    System.out.println(objet.getId() + " : " + objet.getTitle());
                }
        );
        System.out.println("------------------------------------");
        int briefChose = StateController.getInputInt("Choiser le numero de brief");
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
        BriefModel brief = BriefController.getById(briefChose);
        if (brief.setPromoId(promoChose)) {

            String dateAndTime = NotificationController.CurrentDateTime();

            String message = "Bonjour cher apprenant,\nle brief " + brief.getTitle() +
                    " a ete ajoute a vos promo le " + dateAndTime +
                    "\npar votre formateur " + formateur.getFirstName() + " " + formateur.getLastName() + " .";

            Notification.notifications.put(promoChose, new NotificationModel(notificationId, message, promoChose, briefChose));

            Apprenant.apprenants.forEach(
                (index, objet) -> {
                    if (objet.getPromoId() == StartController.user.getPromoId()) {

                        NotificationController.sendEmail(message, objet.getEmail());
                    }
                }
            );


            System.out.println("Le brief est attribuée au promo avec succès");
            return true;
        }

        System.out.println("L'opération n'a pas fonctionné");
        return false;
    }

    public static boolean showBriefs(int promoId) {

        briefs.forEach(
                (index, objet) -> {
                    if (objet.getPromoId() == promoId) {

                        System.out.println(objet.getId() + " : " + objet.getTitle());
                    }
                }
        );
        return true;
    }
    public static BriefModel getById(int id) {

        return briefById.get(id);
    }
}
