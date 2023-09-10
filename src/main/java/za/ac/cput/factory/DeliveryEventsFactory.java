package za.ac.cput.factory;
/*
Student Number:221110933
Name & Surname : Jameelah Gallo
Date: updated the 10th September 2023
 */
import za.ac.cput.domain.DeliveryEvents;
import za.ac.cput.util.Helper;

public class DeliveryEventsFactory {
    public static DeliveryEvents createDeliveryEvents(String deliveryEventId, String deliveryName, String deliveryDate, String deliveryEventLocation){

        deliveryEventId= Helper.generateID();


        if (Helper.isNullOrEmpty(deliveryEventId)||Helper.isNullOrEmpty(deliveryName)||Helper.isNullOrEmpty(deliveryDate)||Helper.isNullOrEmpty(deliveryEventLocation)){
            return null;
        }
        return new DeliveryEvents.Builder()
                .setDeliveryEventId(deliveryEventId)
                .setDeliveryName(deliveryName)
                .setDeliveryDate(deliveryDate)
                .setDeliveryEventLocation(deliveryEventLocation)
                .build();
    }
}
