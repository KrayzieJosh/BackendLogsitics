package za.ac.cput.factory;

import junit.framework.TestCase;
import org.junit.Test;
import za.ac.cput.domain.Driver;
import za.ac.cput.util.Helper;

public class DriverFactoryTest extends TestCase {

    @Test
    public void testCreateNewDriver() {

        Driver driver = DriverFactory.createNewDriver("Lyle", "Esau", "0623458765", "lyle@gmail.com", "delivery driver", Helper.generateID());
        assertNotNull(driver);
        driver.toString();
        System.out.println(driver);
    }
}
