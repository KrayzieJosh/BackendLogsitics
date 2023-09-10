package za.ac.cput.factory;
/*
Student Number:221110933
Name & Surname : Jameelah Gallo
Date: updated  the 10th September 2023
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Notifications;
import za.ac.cput.util.Helper;
import static org.junit.jupiter.api.Assertions.*;

class NotificationsFactoryTest {
    @Test

    public void test(){

        Notifications notification = NotificationsFactory.createNotification(Helper.generateID(),"The vehicle is on route",
                "ON ROUTE");
        assertNotNull(notification);
        System.out.println(notification.toString());

    }
}