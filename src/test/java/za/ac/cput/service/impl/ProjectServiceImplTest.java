package za.ac.cput.service.impl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.util.Helper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class ProjectServiceImplTest {
    @Autowired
    private ProjectServiceImpl service;
    static ProjectManager manager = ProjectManagerFactory.createProjectManagerWithAttributes("123",
            "Foreman","John","Daniel","Johnson","Unavailable","jj@gamil.com");
    static SiteManager siteManager = SiteManagerFactory.createSiteManagerWithAttributes("245",
            "Operations Manager","Daniel","Lyle","Jacobs","N/A",
            "j;@gmail.com");



    static Driver driver = DriverFactory.createNewDriver("Lyle", "Esau", "0623458765", "lyle@gmail.com", "delivery driver");
  
    private static final List<MaterialQuote> materialQuotes = Collections.singletonList(MaterialQuoteFactory.createMaterialQuote(
            Helper.generateID(), "Wood", 11, "12", 12)

    );
    static DeliveryOrder deliveryOrder = DeliveryOrderFactory.createDeliveryOrder(
            "1",
            "123 Main Street",
            "2023-09-15",
            materialQuotes
    );  
  private static final Project project = ProjectFactory.createProject(Helper.generateID(),"Project 1","In progress",manager,siteManager,driver,deliveryOrder);


  @Disabled
    @Test
    void a_create() {
        Project created= service.create(project);
        assertEquals(project.getProjectId(),created.getProjectId());
        System.out.println("Created: " + created);

    }

    @Test
    void b_read() {
        Project read = service.read(project.getProjectId());
        System.out.println("Read " + read);
    }

    @Test
    void c_update() {
        Project updated = new Project.ProjectBuilder().copy(project).setProjectStatus("Done").build();
        assertNotNull(updated);
        System.out.println("Updated" + updated.secondString());
    }
    @Disabled
    @Test
    void e_delete() {

    }

    @Test
    void d_getAll() {
        System.out.println("Get All:");
        System.out.println(service.getAll());
    }
}