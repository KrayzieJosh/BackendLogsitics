package za.ac.cput.controller;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.DeliveryVehicle;
import za.ac.cput.factory.DeliveryVehicleFactory;
import za.ac.cput.util.Helper;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class DeliveryVehicleControllerTest {

    static DeliveryVehicle deliveryVehicle = DeliveryVehicleFactory.createDeliveryVehicle(Helper.generateID(),"Izuzu 2L ",
            "12/05/2023", 25000.00, true);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL ="http://localhost:8080/deliveryVehicle";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL: " + url);
        // post
        ResponseEntity<DeliveryVehicle> postResponse = restTemplate.postForEntity(url, deliveryVehicle, DeliveryVehicle.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        DeliveryVehicle savedDeliveryVehicle = postResponse.getBody();
        assertEquals(savedDeliveryVehicle.getVehicleId(), savedDeliveryVehicle.getVehicleId());
        System.out.println("Saved data: " + savedDeliveryVehicle);
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + deliveryVehicle.getVehicleId();
        System.out.println("URL: " + url);
        // get
        ResponseEntity<DeliveryVehicle> response = restTemplate.getForEntity(url, DeliveryVehicle.class);
        assertEquals(deliveryVehicle.getVehicleId(), response.getBody().getVehicleId());
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }
    @Test
    void c_update() {
        DeliveryVehicle updated = new DeliveryVehicle.Builder()
                .copy(deliveryVehicle)
                .setVehicleName(" test vehicle")
                .build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        // post
        ResponseEntity<DeliveryVehicle> response = restTemplate.postForEntity(url, updated, DeliveryVehicle.class);
        //assertNotNull(response.getBody());
    }

    @Test
    @Disabled
    void d_delete() {
        String url = baseURL + "/delete/"+ deliveryVehicle.getVehicleId();
        System.out.println("URL:" + url); //works
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}