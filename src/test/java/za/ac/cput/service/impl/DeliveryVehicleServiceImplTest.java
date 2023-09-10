package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.DeliveryVehicle;
import za.ac.cput.factory.DeliveryVehicleFactory;
import za.ac.cput.util.Helper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class DeliveryVehicleServiceImplTest {

    @Autowired
    private DeliveryVehicleServiceImpl service;
    public static DeliveryVehicle deliveryVehicle= DeliveryVehicleFactory.createDeliveryVehicle(Helper.generateID(), "Izuzu Delivery Vehicle","04/09/2023",25000.00
            , true);

    @Test
    void a_create() {
        DeliveryVehicle created=service.create(deliveryVehicle);
        assertEquals(deliveryVehicle.getVehicleId(),created.getVehicleId());
        System.out.println("Created : "+created);
    }

    @Test
    void b_read() {
        DeliveryVehicle read=service.read(deliveryVehicle.getVehicleId());
        assertNotNull(read);
        System.out.println("Read : "+read);

    }

    @Test
    void c_update() {
        DeliveryVehicle newDeliveryVehicle = new DeliveryVehicle.Builder().copy(deliveryVehicle).setVehicleName("Mercedez Delivery Vehicle")
                .build();
        DeliveryVehicle updated=service.update(newDeliveryVehicle);
        assertEquals(newDeliveryVehicle.getVehicleName(),updated.getVehicleName());
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