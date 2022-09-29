package SimplonClone.Models;

public class BriefModel {

    private int id;
    private String title;
    private String description;
    private int promoId;
    private int formateurId;

    public BriefModel(int id, String title, String description, int formateurId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.promoId = -1;
        this.formateurId = formateurId;
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
}

