package SimplonClone;


public class Promo {
    private int id;
    private int year;
    private String name;

    public Promo(int id, String name, int year) {
        this.id = id;
        this.year = year;
        this.name = name;
    }

    public static boolean create(int id) {
        String promoName = State.getInputString("Enter le nom de la promo :");
        int promoYear = State.getInputInt("Enter l'annee de la promo :");
        State.promos.put(promoName, new Promo(id, promoName, promoYear));

        if (State.promos.get(promoName) == null){
            System.out.println("La promo n'a pas été créée!");
            return false;
        }

        System.out.println("Promo créée avec succès");

        return true;
    }

//    public static Promo getPromoByName(String promoName) {
//        return State.promos.get(promoName);
//    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }


}
