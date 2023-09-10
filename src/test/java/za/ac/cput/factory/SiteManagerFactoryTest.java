package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.SiteManager;

import static org.junit.jupiter.api.Assertions.*;

class SiteManagerFactoryTest {

    @Test
    void createSiteManager() {


        SiteManager siteManager = SiteManagerFactory.createSiteManagerWithAttributes(
                "id777","Operations manager","Nathan","James","Lange",
                "0254789631","njl@gmail.com");
        assertNotNull(siteManager);
        System.out.println(siteManager.secondString());
    }
}