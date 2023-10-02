package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Company;
import za.ac.cput.domain.Project;
import za.ac.cput.util.Helper;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyFactoryTest {


    @Test
    void createCompany() {

         List<Project> projects = Collections.singletonList(ProjectFactory.createProjectDetails(Helper.generateID(),"Project 2,","Done"));

         Company company = CompanyFactory.createCompany(Helper.generateID(),"Wayne Enterprises",
                " 224 Park Drive Gotham City","bw@wenterprises.com",projects);

        assertNotNull(company);
        System.out.println(company.toString());


    }
}