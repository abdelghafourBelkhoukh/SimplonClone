package SimplonClone;

public class Apprenant extends Person{

    public Apprenant(int id, String firstName, String lastName, String Email, String password) {
        super( id, -1, firstName, lastName, Email, password, Role.APPRENANT);
    }

    public static boolean create(int id) {

        System.out.println("Pour créer un compte Apprenant,\nremplissez les champs suivants :");

        String firstName = State.getInputString("Entrer le prenom:");
        String lastName = State.getInputString("Entrer le nom :");
        String email = State.getInputString("Entrer l'email :");
        String password = State.getInputString("Entrer le password :");
        Apprenant apprenant = new Apprenant(id, firstName, lastName, email, password);
        State.apprenants.put(email, apprenant);
        State.apprenants.put(email, apprenant);

        if (State.apprenants.get(email) == null){
            System.out.println("La compte apprenant n'a pas été créée!");
            return false;
        }
        System.out.println("compte apprenant créée avec succès");
        return true;

    }

    public static boolean asignToPromo() {

        System.out.println("-------------------------");
        System.out.println("-  Liste des Apprenant  -");
        System.out.println("-------------------------");
        State.apprenants.forEach(
                (index, objet) -> System.out.println(objet.getId() + " : " + objet.getFirstName() + " " + objet.getLastName())
        );
        System.out.println("------------------------------------");
        int apprenantChose = State.getInputInt("Choiser le numero d'apprenant");
        // clear console here
        System.out.println("----------------------");
        System.out.println("-  Liste des promos  -");
        System.out.println("----------------------");
        State.promos.forEach(
                (index, objet) -> System.out.println(objet.getId() + " : " + objet.getName())
        );
        System.out.println("------------------------------------");
        int promoChose = State.getInputInt("Choiser le numero du formateur");
        //clear console here
        Apprenant apprenant = getApprenantById(apprenantChose);

        if (apprenant.setPromoId(promoChose)){

            System.out.println("La promo est attribuée au compte formateur avec succès");
            return true;
        }

        System.out.println("L'opération n'a pas fonctionné");
        return false;
    }

    public static Apprenant getApprenantById(int id) {

        return State.apprenantsById.get(id);
    }
}
