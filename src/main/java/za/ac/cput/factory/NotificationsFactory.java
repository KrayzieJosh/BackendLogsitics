package za.ac.cput.factory;
/*
Student Number:221110933
Name & Surname : Jameelah Gallo
Date: updated the  10th September 2023
 */
import za.ac.cput.domain.Notifications;
import za.ac.cput.util.Helper;

public class NotificationsFactory {
    public static Notifications createNotification(String notificationId, String notificationMessage, String notificationStatus){

        notificationId= Helper.generateID();

        if(Helper.isNullOrEmpty(notificationId)||Helper.isNullOrEmpty(notificationMessage)||Helper.isNullOrEmpty(notificationStatus)){
            return null;
        }

        return new Notifications.Builder()
                .setNotificationId(notificationId)
                .setNotificationMessage(notificationMessage)
                .setNotificationStatus(notificationStatus)
                .build();
    }
}
