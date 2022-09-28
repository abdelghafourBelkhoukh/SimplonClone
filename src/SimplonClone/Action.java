package SimplonClone;

public class Action {

    public static boolean showBriefs(int promoId) {

        State.briefs.forEach(
                (index, objet) -> {
                    if (objet.getId() == promoId){

                        System.out.println(objet.getId() + " : " + objet.getTitle());
                    }
                }
        );
        return true;
    }

    public static boolean logout() {
        Auth.setUser(null);
//        todo: remove admin when logged out

        return true;
    }

}
