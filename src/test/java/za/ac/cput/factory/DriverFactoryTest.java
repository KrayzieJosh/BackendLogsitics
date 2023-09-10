package za.ac.cput.factory;

import junit.framework.TestCase;
import org.junit.Test;
import za.ac.cput.domain.DeliveryVehicle;
import za.ac.cput.domain.Driver;
import za.ac.cput.util.Helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverFactoryTest extends TestCase {

    @Test
    public void testCreateNewDriver() {

        List<DeliveryVehicle> vehicles = Collections.singletonList(DeliveryVehicleFactory.createDeliveryVehicle(Helper.generateID(), "Kia Sport", "10/12/25", 55, true));
        Driver driver = DriverFactory.createNewDriver("Lyle", "Esau", "0623458765", "lyle@gmail.com", "delivery driver");
        assertNotNull(driver);
        System.out.println(driver.secondString());
    }

    @Test
    public void testCreateNewDriverWithVehicles(){

        List<DeliveryVehicle> vehicles = Collections.singletonList(DeliveryVehicleFactory.createDeliveryVehicle(Helper.generateID(), "Kia Sport", "10/12/25", 55, true));
        Driver driver = DriverFactory.createNewDriverWithVehicles("Lyle", "Esau", "0623458765", "lyle@gmail.com", "delivery driver", vehicles);
        assertNotNull(driver);
        System.out.println(driver.toString());
    }

}
