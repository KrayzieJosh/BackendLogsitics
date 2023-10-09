package za.ac.cput.service.impl;
/*
Student Number:221110933
Name & Surname : Jameelah Gallo
Date: updated  the 10th September 2023
 */
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.DeliveryEvents;
import za.ac.cput.domain.Location;
import za.ac.cput.factory.DeliveryEventsFactory;
import za.ac.cput.factory.LocationFactory;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class DeliveryEventsServiceImplTest {

    @Autowired
    private DeliveryEventsServiceImpl service;



    private static DeliveryEvents deliveryEvents= DeliveryEventsFactory.createDeliveryEvents(Helper.generateID(), "Normal delivery", LocalDateTime.now()
            , 2, "Janari Road","Grassy Park",7941);
    @Test
    void a_create() {
        DeliveryEvents created=service.create(deliveryEvents);
        assertEquals(deliveryEvents.getDeliveryEventId(),created.getDeliveryEventId());
        System.out.println("Created : "+created);
    }

    @Test
    void b_read() {
        DeliveryEvents read=service.read(deliveryEvents.getDeliveryEventId());
        assertNotNull(read);
        System.out.println("Read : "+read);

    }

    @Test
    void c_update() {
        DeliveryEvents newDeliveryEvent=new DeliveryEvents.Builder().copy(deliveryEvents).setDeliveryName("Same day").build();
        DeliveryEvents updated=service.update(newDeliveryEvent);
        assertEquals(newDeliveryEvent.getDeliveryName(),updated.getDeliveryName());
        System.out.println("Updated : "+updated);

    }

    @Test
    @Disabled
    void e_delete() {
    }

    @Test
    void d_getAll() {
        System.out.println("Get All : ");
        System.out.println(service.getAll());
    }
}