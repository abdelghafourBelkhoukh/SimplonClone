package SimplonClone;

public class Formateur extends Person{

    public Formateur(int id, String firstName, String lastName, String Email, String password) {
        super( id, -1, firstName, lastName, Email, password, Role.FORMATEUR);
    }

    public static boolean create(int newFormateurId) {
        System.out.println("Pour créer un compte formateur,\nremplissez les champs suivants :");
        String firstName = State.getInputString("Entrer le prenom:");
        String lastName = State.getInputString("Entrer le nom");
        String email = State.getInputString("Entrer l'email :");
//        String promoName = State.getInputString("Entrer le nom de la promo :");
//        Promo promo = getPromoByName(promoName);
//        int promoId = promo.getId();
        String password = State.getInputString("Entrer le password :");

        Formateur formateur = new Formateur(newFormateurId, firstName, lastName, email, password);
        State.formateurs.put(email, formateur);
        State.formateursById.put(newFormateurId, formateur);

        if (State.formateurs.get(email) == null){
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
        State.formateurs.forEach(
                (index, objet) -> System.out.println(objet.getId() + " : " + objet.getFirstName() + " " + objet.getLastName())
        );
        System.out.println("------------------------------------");
        int formateurChose = State.getInputInt("Choiser le numero du formateur");
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
        Formateur formateur = getFormateurById(formateurChose);

        if (formateur.setPromoId(promoChose)){

            System.out.println("La promo est attribuée au compte formateur avec succès");
            return true;
        }

            System.out.println("L'opération n'a pas fonctionné");
        return false;
    }

    public static Formateur getFormateurById(int id) {

       return State.formateursById.get(id);
    }
}
