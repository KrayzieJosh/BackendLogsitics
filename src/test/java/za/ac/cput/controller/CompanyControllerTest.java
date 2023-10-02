package za.ac.cput.controller;

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
import za.ac.cput.domain.Company;
import za.ac.cput.domain.Project;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.factory.CompanyFactory;
import za.ac.cput.factory.ProjectFactory;
import za.ac.cput.factory.ProjectManagerFactory;
import za.ac.cput.factory.SiteManagerFactory;
import za.ac.cput.util.Helper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CompanyControllerTest {

    static List<Project> projects = Collections.singletonList(ProjectFactory.createProjectDetails(Helper.generateID(), "Project 2,", "Done"));

    static Company company = CompanyFactory.createCompany(Helper.generateID(),"Wayne Enterprises",
         " 224 Park Drive Gotham City","bw@wenterprises.com",projects);

 @Autowired
 private TestRestTemplate restTemplate;
 private final String baseURL = "http://localhost:8080/company";
    @Test
    void a_create() {
     String url = baseURL + "/create";
     ResponseEntity<Company> postResponse = restTemplate.postForEntity(url, company, Company.class);
     assertNotNull(postResponse);
     assertNotNull(postResponse.getBody());
     Company createdCompany = postResponse.getBody();

     assertNotNull(createdCompany);
     assertEquals(createdCompany.getCompanyId(), company.getCompanyId());

     System.out.println("Saved data: " + createdCompany.toString());
    }

    @Test
    void b_read() {
     String url=baseURL + "/read/"+ company.getCompanyId();
     System.out.println("URL:" +url);
     ResponseEntity<Company> response = restTemplate.getForEntity(url, Company.class);
     System.out.println(response.getBody());
    }

    @Test
    void c_update() {
     Company updated= new Company.Builder().copy(company).setCompanyName("Joker Enterprises").build();
     String url=baseURL + "/update";
     System.out.println("URL:" + url );
     System.out.println("Post data:" + updated);
     ResponseEntity<Company> response = restTemplate.postForEntity(url,updated, Company.class);
     assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
     String url=baseURL + "/delete/" + company.getCompanyId();
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