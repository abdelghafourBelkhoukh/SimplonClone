package SimplonClone;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Notification {
    private int id;
    private String message;
    private int promoId;
    private int briefId;


    public Notification(int id, String message, int promoId, int briefId) {
        this.id = id;
        this.message = message;
        this.promoId = promoId;
        this.briefId = briefId;
    }
    public static String CurrentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static void getEmail(int promoId){
        State.notifications.forEach(
                (index, objet) -> {
                    if (objet.getPromoId() == promoId){

                        System.out.println(objet.getMessage());
                        System.out.println("-------------------------------------------------------------------------------");
                    }
                }
        );

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPromoId(int promoId) {
        this.promoId = promoId;
    }

    public void setBriefId(int briefId) {
        this.briefId = briefId;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public int getPromoId() {
        return promoId;
    }

    public int getBriefId() {
        return briefId;
    }

//    public static Notification mail(){
//
//
//    }


}
