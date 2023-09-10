package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Project;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.util.Helper;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectManagerFactoryTest {
    @Test
    void createProjectManagerDetails() {

        SiteManager siteManager = SiteManagerFactory.createSiteManagerWithAttributes("24",
                "operations manager","Darren","Ingrid","Watkins","N/A","dwatkins@gmail.com");



        ProjectManager projectManager = ProjectManagerFactory.createProjectManagerWithAttributes(
                "123","Foreman","Bruce","John","Wayne","N/A",
                "bwayne@wayneEnterprises.co.gt");
        assertNotNull(projectManager);
        System.out.println(projectManager.secondString());
    }

    @Test
    void createProjectManagerWithProjects(){
        List<Project> projectDetails= Collections.singletonList(ProjectFactory.createProjectDetails(Helper.generateID(), "Project 1", "Done"));
        ProjectManager projectManager = ProjectManagerFactory.createProjectManagerWithProject("1234",
                "Fired","David","N/A","Goliath","123456789","david@gmail.com",
                projectDetails);
        assertNotNull(projectManager);
        System.out.println(projectManager.toString());
    }

}