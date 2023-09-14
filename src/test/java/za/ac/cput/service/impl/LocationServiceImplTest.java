package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Location;
import za.ac.cput.factory.LocationFactory;
import za.ac.cput.service.LocationService;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class LocationServiceImplTest {

    @Autowired
    private LocationService service; // Inject the LocationService bean

    private static Location location = LocationFactory.createLocation(Helper.generateID(), "Construction Site A", 12,"Botterblom street","Cape Town",7580);

    @Test
    void a_create() {
        Location created = service.create(location);
        System.out.println("Create: " + created);
        assertNotNull(created);
    }

    @Test
    void b_read() {
        Location read = service.read(location.getLocationId());
        System.out.println("Read: " + read);
        assertNotNull(read);
    }

    @Test
    void c_update() {
        Location updated = new Location.Builder().copy(location).setLocationId("789-789-456")
                .build();
        //assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        String id = location.getLocationId();
        boolean success = service.delete(id);
        assertTrue(success);
        System.out.println("Success: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all:");
        System.out.println(service.getAll());
    }
}
