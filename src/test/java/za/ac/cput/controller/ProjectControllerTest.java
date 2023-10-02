package za.ac.cput.controller;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.util.Helper;
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

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProjectControllerTest {
    static ProjectManager projectManager = ProjectManagerFactory.createProjectManagerWithAttributes(
            "123","Foreman","Bruce","John","Wayne","N/A",
            "bwayne@wayneEnterprises.co.gt");
    static SiteManager siteManager = SiteManagerFactory.createSiteManagerWithAttributes("345",
            "Engineer","Lucius","Morgan","Fox","N/A",
            "lfox@wayenenterprises.co.gt");
    static Company company = CompanyFactory.createCompanyWithoutProject(Helper.generateID(),"Wayne Enterprises",
            " 224 Park Drive Gotham City","bw@wenterprises.com");

    private static List<MaterialQuote> materialQuotes = Arrays.asList(MaterialQuoteFactory.createMaterialQuote(
            Helper.generateID(),"Wood",11,"12",12)

    );
    static DeliveryOrder deliveryOrder = DeliveryOrderFactory.createDeliveryOrder(
            "1",
            "123 Main Street",
            "2023-09-15",
            materialQuotes
    );

    static Driver driver = DriverFactory.createNewDriver("Lyle", "Esau", "0623458765", "lyle@gmail.com", "delivery driver");
    static Project project = ProjectFactory.createProject(Helper.generateID(),"Project 1","Almost done"
            ,projectManager,siteManager,driver,company,deliveryOrder);


    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/project";
    @Test
    void a_create() {
        String url = baseURL + "/create";
        System.out.println("URL: " + url);
        ResponseEntity<Project> postResponse=restTemplate.postForEntity(url,project,Project.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Project savedProject =postResponse.getBody();
        assertEquals(savedProject.getProjectId(),savedProject.getProjectId());

        assertNotNull(savedProject);
        System.out.println("Saved data: " + savedProject.secondString());

    }

    @Test
    void b_read() {
        String url=baseURL + "/read/"+ project.getProjectId();
        System.out.println("URL:" +url);
        ResponseEntity<Project> response = restTemplate.getForEntity(url, Project.class);
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Project updated= new Project.ProjectBuilder()
                .copy(project).setProjectStatus("Unfinished").build();
        String url=baseURL + "/update";
        System.out.println("URL:" + url );
        System.out.println("Post data:" + updated);
        ResponseEntity<Project> response = restTemplate.postForEntity(url,updated, Project.class);
    }
    @Disabled
    @Test
    void e_delete() {
        String url=baseURL + "/delete/" + project.getProjectId();
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