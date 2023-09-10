package za.ac.cput.factory;
/*
Student Number:221110933
Name & Surname : Jameelah Gallo
Date: updated  the 10th September 2023
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.DeliveryEvents;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryEventsFactoryTest {
    @Test

    public void test(){





        DeliveryEvents deliveryEvent =  DeliveryEventsFactory.createDeliveryEvents
                (Helper.generateID(),"John Wattkins","17-06-2023"
                        ,"56 Epping Industria");

        assertNotNull(deliveryEvent);

        System.out.println(deliveryEvent.toString());

    }
}

