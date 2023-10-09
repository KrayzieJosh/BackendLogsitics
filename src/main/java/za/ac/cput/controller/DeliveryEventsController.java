package za.ac.cput.controller;
/*
Student Number:221110933
Name & Surname : Jameelah Gallo
Date: updated the  10th September 2023
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.DeliveryEvents;
import za.ac.cput.factory.DeliveryEventsFactory;
import za.ac.cput.service.DeliveryEventsService;

import java.util.List;

@RestController
@RequestMapping("/deliveryEvents")

public class DeliveryEventsController {
    @Autowired
    private DeliveryEventsService deliveryEventsService;

    @PostMapping("/create")
    public DeliveryEvents create(@RequestBody DeliveryEvents deliveryEvents) {

        return deliveryEventsService.create(deliveryEvents);
    }

    @GetMapping("/read/{deliveryEventsId}")
    public DeliveryEvents read(@PathVariable String deliveryEventsId) {
        return deliveryEventsService.read(deliveryEventsId);
    }

    @PostMapping("/update")
    public DeliveryEvents update(@RequestBody DeliveryEvents deliveryEvents) {
        return deliveryEventsService.update(deliveryEvents);
    }

    @DeleteMapping("delete/{deliveryEventsId}")
    public boolean delete(@PathVariable String deliveryEventsId) {
        return deliveryEventsService.delete(deliveryEventsId);
    }

    @GetMapping("/getall")
    public List<DeliveryEvents> getAll() {
        return deliveryEventsService.getAll();
    }


}
