package SimplonClone;

public class Brief {

    private int id;
    private String title;
    private String description;
    private int promoId;
    private int formateurId;

    public Brief(int id, String title, String description, int formateurId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.promoId = -1;
        this.formateurId = formateurId;
    }

    public static boolean createBrief(int id) {

        System.out.println("Pour créer un brief,\nremplissez les champs suivants :");
        String title = State.getInputString("Entrer le titre");
        String description = State.getInputString("Entrer une description");
        Person formateur = Auth.getUser();
        int formateurId = formateur.getId();
        Brief brief = new Brief(id, title, description, formateurId);
        State.briefs.put(title, brief);
        State.briefById.put(id, brief);
        if (State.briefs.get(title) != null){
            System.out.println("Brief added");
            return true;
        }

        System.out.println("Brief not added");
        return false;
    }

    public static boolean asignToPromo(int notificationId, Person formateur) {

        System.out.println("-------------------------");
        System.out.println("-  Liste des Briefs  -");
        System.out.println("-------------------------");
        State.briefs.forEach(
                (index, objet) -> {
                        System.out.println(objet.getId() + " : " + objet.getTitle());
                    }
        );
        System.out.println("------------------------------------");
        int briefChose = State.getInputInt("Choiser le numero de brief");
        // clear console here
        System.out.println("----------------------");
        System.out.println("-  Liste des promos  -");
        System.out.println("----------------------");
        State.promos.forEach(
                (index, objet) -> System.out.println(objet.getId() + " : " + objet.getName())
        );
        System.out.println("------------------------------------");
        int promoChose = State.getInputInt("Choiser le numero de la promo");
        //clear console here
        Brief brief = getById(briefChose);
        if (brief.setPromoId(promoChose)){

            String dateAndTime = Notification.CurrentDateTime();

            String message = "Bonjour cher apprenant,\nle brief " + brief.getTitle() +
                    " a été ajouté à vos promo le " + dateAndTime +
                    "\npar votre formateur " + formateur.getFirstName() + " " + formateur.getLastName() + " .";

            State.notifications.put(promoChose, new Notification(notificationId, message, promoChose, briefChose));
            System.out.println("Le brief est attribuée au promo avec succès");
            return true;
        }

        System.out.println("L'opération n'a pas fonctionné");
        return false;
    }

    public static boolean showBriefs(int promoId) {

        State.briefs.forEach(
                (index, objet) -> {
                    if (objet.getPromoId() == promoId){

                        System.out.println(objet.getId() + " : " + objet.getTitle());
                    }
                }
        );
        return true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPromoId() {
        return promoId;
    }

    public int getFormateurId() {
        return formateurId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean setPromoId(int promoId) {
        this.promoId = promoId;
        return true;
    }

    public void setFormateurId(int formateurId) {
        this.formateurId = formateurId;
    }
    public static Brief getById(int id) {

        return State.briefById.get(id);
    }
}

