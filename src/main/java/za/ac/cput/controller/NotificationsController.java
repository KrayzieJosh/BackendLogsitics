package za.ac.cput.controller;
/*
Student Number:221110933
Name & Surname : Jameelah Gallo
Date: updated the 10th September 2023
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Notifications;
import za.ac.cput.factory.NotificationsFactory;
import za.ac.cput.service.NotificationsService;

import java.util.List;

@RestController
@RequestMapping("/notifications")

public class NotificationsController {
    @Autowired
    private NotificationsService notificationsService;

    @PostMapping("/create")
    public Notifications create(@RequestBody Notifications notifications) {


        Notifications notificationsCreated = NotificationsFactory.createNotification(notifications.getNotificationId(), notifications.getNotificationMessage(), notifications.getNotificationStatus());

        return notificationsService.create(notifications);
    }

    @GetMapping("/read/{notificationsId}")
    public Notifications read(@PathVariable String notificationsId) {
        return notificationsService.read(notificationsId);
    }

    @PostMapping("/update")
    public Notifications update(@RequestBody Notifications notifications) {
        return notificationsService.update(notifications);
    }

    @GetMapping("/getall")
    public List<Notifications> getAll() {
        return notificationsService.getAll();
    }


}

