package SimplonClone.Models;

import SimplonClone.Models.BriefModel;
import SimplonClone.Models.NotificationModel;
import SimplonClone.Models.PromoModel;
import SimplonClone.Models.User.ApprenantModel;
import SimplonClone.Models.User.FormateurModel;
import SimplonClone.Models.User.PersonModel;

import java.util.HashMap;

public class StateModel {
    public static HashMap<String, PromoModel> promos = new HashMap<>();
    public static HashMap<String, FormateurModel> formateurs = new HashMap<>();
    public static HashMap<Integer, FormateurModel> formateursById = new HashMap<>();
    public static HashMap<String, ApprenantModel> apprenants = new HashMap<>();
    public static HashMap<Integer, ApprenantModel> apprenantsById = new HashMap<>();
    public static HashMap<Integer, ApprenantModel> apprenantsByPromoId = new HashMap<>();
    public static HashMap<String, BriefModel> briefs = new HashMap<>();
    public static HashMap<Integer, BriefModel> briefById = new HashMap<>();
    public static HashMap<Integer, NotificationModel> notifications = new HashMap<>();
    public static  HashMap<String, PersonModel> userByEmail;
    public static int newPromoId = 1;
    public static int newFormateurId = 1;
    public static int newApprenantId = 1;
    public static int newBriefId = 1;
    public static int newNotificationId = 1;


    // Commands methods

}
