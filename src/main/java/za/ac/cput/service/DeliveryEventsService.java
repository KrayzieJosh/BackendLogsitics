package za.ac.cput.service;
/*
Student Number:221110933
Name & Surname : Jameelah Gallo
Date: updated the 10th September 2023
 */
import za.ac.cput.domain.DeliveryEvents;

import java.util.List;

public interface DeliveryEventsService {
    DeliveryEvents create(DeliveryEvents deliveryEvent);

    DeliveryEvents read(String deliveryEventId);

    DeliveryEvents update (DeliveryEvents deliveryEvent);

    boolean delete(String deliveryEventId);

    public List<DeliveryEvents> getAll();
}