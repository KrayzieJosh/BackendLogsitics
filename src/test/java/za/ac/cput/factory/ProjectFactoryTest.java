package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
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

        Driver driver = DriverFactory.createNewDriver("Lyle", "Esau", "0623458765", "lyle@gmail.com", "delivery driver");
         Company company = CompanyFactory.createCompanyWithoutProject(Helper.generateID(),"Wayne Enterprises",
                " 224 Park Drive Gotham City","bw@wenterprises.com");
  DeliveryOrder deliveryOrder = DeliveryOrderFactory.createDeliveryOrder(
                "1",
                "123 Main Street",
                "2023-09-15",
                materialQuotes
        );
        List<MaterialQuote> materialQuotes = Arrays.asList(MaterialQuoteFactory.createMaterialQuote(
                Helper.generateID(),"Wood",11,"12",12)

        Project project = ProjectFactory.createProject(Helper.generateID(),"Project1","In progress", projectManager, siteManager,driver,company,deliveryOrder);

        
       

        
        assertNotNull(project);
        System.out.println(project.toString());
    }

    @Test

    void createProjectDetails(){
        Project project = ProjectFactory.createProjectDetails(Helper.generateID(),"Project 2,","Done");
        assertNotNull(project);
        System.out.println("Project Details " + project.secondString());
    }
}