package SimplonClone.Models;

public class NotificationModel {
    private int id;
    private String message;
    private int promoId;
    private int briefId;


    public NotificationModel(int id, String message, int promoId, int briefId) {
        this.id = id;
        this.message = message;
        this.promoId = promoId;
        this.briefId = briefId;
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
