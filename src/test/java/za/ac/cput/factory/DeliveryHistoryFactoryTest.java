package za.ac.cput.factory;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.DeliveryHistory;
import za.ac.cput.util.Helper;

public class DeliveryHistoryFactoryTest extends TestCase {

    @Test
    public void testCreateNewDeliveryHistory(){

        DeliveryHistory deliveryHistory = DeliveryHistoryFactory.createNewDeliveryHistory(Helper.generateID(), Helper.generateID());
        assertNotNull(deliveryHistory);
        System.out.println(deliveryHistory.toString());
    }
}

