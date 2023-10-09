package za.ac.cput.factory;
/*
Student Number:221110933
Name & Surname : Jameelah Gallo
Date: updated the  10th September 2023
 */
import org.springframework.lang.NonNull;
import za.ac.cput.domain.DeliveryEvents;
import za.ac.cput.domain.Location;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

public class DeliveryEventsFactory {
    public static DeliveryEvents createDeliveryEvents(String deliveryEventId, String deliveryName, LocalDateTime deliveryDate,  int streetNumber,
    String streetName,String townOrCity, int areaCode){

        deliveryEventId= Helper.generateID();


        if (Helper.isNullOrEmpty(deliveryEventId)||Helper.isNullOrEmpty(deliveryName)||Helper.isNullOrEmpty(String.valueOf(streetNumber))||Helper.isNullOrEmpty(streetName)
        ||Helper.isNullOrEmpty(townOrCity)||Helper.isNullOrEmpty(String.valueOf(areaCode))){
            return null;
        }
        return new DeliveryEvents.Builder()
                .setDeliveryEventId(deliveryEventId)
                .setDeliveryName(deliveryName)
                .setDeliveryDate(deliveryDate)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setTownOrCity(townOrCity)
                .setAreaCode(areaCode)
                .build();
    }
}
