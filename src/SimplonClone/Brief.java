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
        State.briefs.put(title, new Brief(id, title, description, formateurId));
        if (State.briefs.get(title) != null){
            System.out.println("Brief added");
            return true;
        }

        System.out.println("Brief not added");
        return false;
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

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    public void setFormateurId(int formateurId) {
        this.formateurId = formateurId;
    }
}

