package za.ac.cput.service;
/*
Student Number:221110933
Name & Surname : Jameelah Gallo
Date: updated  the 10th September 2023
 */
import za.ac.cput.domain.Notifications;

import java.util.List;

public interface NotificationsService  {

    Notifications create(Notifications notification);

    Notifications read(String notificationId);

    Notifications update (Notifications notification);

    boolean delete(String notificationId);

    public List<Notifications> getAll();
}
