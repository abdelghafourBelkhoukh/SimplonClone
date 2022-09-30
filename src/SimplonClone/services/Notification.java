package SimplonClone.services;

import SimplonClone.Models.StateModel;
import SimplonClone.Models.User.ApprenantModel;
import models.SendEnhancedRequestBody;
import models.SendEnhancedResponseBody;
import models.SendRequestMessage;
import services.Courier;
import services.SendService;

import java.io.IOException;
import java.util.*;

public class Notification {
    public static void getEmail(int promoId) {
        ApprenantModel test = StateModel.apprenantsByPromoId.get(promoId);
        StateModel.notifications.forEach(
                (index, objet) -> {
                    if (objet.getPromoId() == promoId) {

                        System.out.println(objet.getMessage());
                        System.out.println("-------------------------------------------------------------------------------");

                    }
                }
        );
    }

    public static void sendEmail(String mailMessage, String mail)
    {
        Courier.init("pk_prod_YFX88J0RXZM3WRQ2M0FTHWF4BMV7");

        SendEnhancedRequestBody sendEnhancedRequestBody = new SendEnhancedRequestBody();
        SendRequestMessage sendRequestMessage = new SendRequestMessage();
        HashMap<String, String> to = new HashMap<String, String>();
        to.put("email", mail);
        sendRequestMessage.setTo(to);

        HashMap<String, String> content = new HashMap<String, String>();
        content.put("title", "Nouveau brief");
        content.put("body", mailMessage);
        sendRequestMessage.setContent(content);

        sendEnhancedRequestBody.setMessage(sendRequestMessage);

        try {
            SendEnhancedResponseBody response = new SendService().sendEnhancedMessage(sendEnhancedRequestBody);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
