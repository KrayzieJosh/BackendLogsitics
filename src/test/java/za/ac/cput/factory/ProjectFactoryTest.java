package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Project;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;


import java.util.*;


class ProjectFactoryTest {

    @Test
    void createProject() {
        ProjectManager projectManager = ProjectManagerFactory.createProjectManagerWithAttributes(
                "123","Foreman","Bruce","John","Wayne","N/A",
                "bwayne@wayneEnterprises.co.gt");
        SiteManager siteManager = SiteManagerFactory.createSiteManagerWithAttributes("345",
                "Engineer","Lucius","Morgan","Fox","N/A",
                "lfox@wayenenterprises.co.gt");

        Driver driver = DriverFactory.createNewDriver("Lyle", "Esau", "0623458765", "lyle@gmail.com", "delivery driver", Helper.generateID());



        Project project = ProjectFactory.createProject(Helper.generateID(),"Project1","In progress", projectManager, siteManager,driver);
        assertNotNull(project);
        System.out.println(project.secondString());
    }

    @Test

    void createProjectDetails(){
        Project project = ProjectFactory.createProjectDetails(Helper.generateID(),"Project 2,","Done");
        assertNotNull(project);
        System.out.println("Project Details " + project.secondString());
    }
}