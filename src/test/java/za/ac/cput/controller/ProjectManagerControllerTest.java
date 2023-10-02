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
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.factory.ProjectManagerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProjectManagerControllerTest {
    static ProjectManager manager = ProjectManagerFactory.createProjectManagerWithAttributes(
            "123","Foreman","Bruce","John","Wayne","N/A",
            "bwayne@wayneEnterprises.co.gt");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/projectManager";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<ProjectManager> postResponse = restTemplate.postForEntity(url, manager, ProjectManager.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        ProjectManager createdProjectManager = postResponse.getBody();

        assertNotNull(createdProjectManager);
        assertEquals(createdProjectManager.getProjectManagerId(), createdProjectManager.getProjectManagerId());

        System.out.println("Saved data: " + createdProjectManager.secondString());
    }

    @Test
    void b_read() {
        String url=baseURL + "/read/"+ manager.getProjectManagerId();
        System.out.println("URL:" +url);
        ResponseEntity<ProjectManager> response = restTemplate.getForEntity(url, ProjectManager.class);
        System.out.println(response.getBody().secondString());
    }

    @Test
    void c_update() {
        ProjectManager updated= new ProjectManager.ProjectManagerBuilder()
                .copy(manager).setPosition("Fired").build();
        String url=baseURL + "/update";
        System.out.println("URL:" + url );
        System.out.println("Post data:" + updated.secondString());
        ResponseEntity<ProjectManager> response = restTemplate.postForEntity(url,updated, ProjectManager.class);
        assertNotNull(response.getBody());

    }
    @Disabled
    @Test
    void e_delete() {
        String url=baseURL + "/delete/" + manager.getProjectManagerId();
        System.out.println("URL:" + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getall";
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> entity= new HttpEntity<>(null,httpHeaders);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println("Show all:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}