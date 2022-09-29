package SimplonClone.Controllers;

import SimplonClone.services.Notification;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NotificationController {
    public static String CurrentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static void getEmail(int promoId) {

        Notification.getEmail(promoId);
    }
    public static void sendEmail(String message, String mail) {

        Notification.sendEmail(message, mail);
    }
}
