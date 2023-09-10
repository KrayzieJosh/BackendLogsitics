package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.DeliveryVehicle;
import za.ac.cput.util.Helper;
import static org.junit.jupiter.api.Assertions.*;

class DeliveryVehicleFactoryTest {

    @Test
    public void createDeliveryVehicle() {
        DeliveryVehicle deliveryVehicle = DeliveryVehicleFactory.createDeliveryVehicle(
                Helper.generateID(),"Izuzu Delivery vehicle","03/09/2023",25000.00
                ,true);

        assertNotNull(deliveryVehicle);
        System.out.println(deliveryVehicle.toString());

    }
}