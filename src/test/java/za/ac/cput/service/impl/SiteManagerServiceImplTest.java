package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Project;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.factory.ProjectFactory;
import za.ac.cput.factory.SiteManagerFactory;
import za.ac.cput.util.Helper;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class SiteManagerServiceImplTest {
    @Autowired
    private SiteManagerServiceImpl service;
    static List<Project> projectList= Collections.singletonList(ProjectFactory.createProjectDetails(Helper.generateID(), "Project 1", "In progress"));

    private static final SiteManager siteManager = SiteManagerFactory.createSiteManagerWithAttributes("7689","Not Manager","Lemon","Oros"
            ,"Man","0217062300","oros@gmail.com");
    @Test
    void a_create() {
        SiteManager created= service.create(siteManager);
        assertEquals(siteManager.getSiteManagerId(),created.getSiteManagerId());
        System.out.println("Created: " + created);

    }

    @Test
    void b_read() {
        SiteManager read = service.read(siteManager.getSiteManagerId());
        System.out.println("Read " + read);
    }

    @Test
    void c_update() {
        SiteManager updated = new SiteManager.SiteManagerBuilder().copy(siteManager).setPosition("Foreman").build();
        assertNotNull(updated);
        System.out.println("Updated" + updated);
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