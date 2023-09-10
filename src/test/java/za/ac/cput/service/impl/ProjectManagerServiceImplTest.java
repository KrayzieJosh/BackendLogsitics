package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Project;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.factory.ProjectFactory;
import za.ac.cput.factory.ProjectManagerFactory;
import za.ac.cput.util.Helper;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class ProjectManagerServiceImplTest {
    @Autowired
    private ProjectManagerServiceImpl service;
    static List<Project> projectList= Collections.singletonList(ProjectFactory.createProjectDetails(Helper.generateID(), "Project 1", "In progress"));

    private static final ProjectManager projectManager = ProjectManagerFactory.createProjectManagerWithAttributes(
            "123","Foreman","Bruce","John","Wayne","N/A",
            "bwayne@wayneEnterprises.co.gt");
    @Test
    void a_create() {
        ProjectManager created= service.create(projectManager);
        assertEquals(projectManager.getProjectManagerId(),created.getProjectManagerId());
        System.out.println("Created: " + created.secondString());

    }

    @Test
    void b_read() {
        ProjectManager read = service.read(projectManager.getProjectManagerId());
        System.out.println("Read " + read.secondString());
    }

    @Test
    void c_update() {
        ProjectManager updated = new ProjectManager.ProjectManagerBuilder().copy(projectManager).setPosition("Intern").build();
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