package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Company;
import za.ac.cput.domain.Project;
import za.ac.cput.factory.CompanyFactory;
import za.ac.cput.factory.ProjectFactory;
import za.ac.cput.util.Helper;

import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class CompanyServiceImplTest {

    @Autowired
    private CompanyServiceImpl service;

    static List<Project> projects = Collections.singletonList(ProjectFactory.createProjectDetails(Helper.generateID(),"Project 2,","Done"));

    static Company company = CompanyFactory.createCompany(Helper.generateID(),"Wayne Enterprises",
            " 224 Park Drive Gotham City","bw@wenterprises.com",projects);

    @Test
    void a_create() {
        Company created = service.create(company);
        assertEquals(company.getCompanyId(), created.getCompanyId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Company read = service.read(company.getCompanyId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Company updated = new Company.Builder()
                .copy(company)
                .setCompanyPhysicalAddress("371 BlackWater BusinessPark Metropolis")
                .build();
        assertNotNull(updated);
        System.out.println("Update: " + updated);
    }

    @Test
    @Disabled
    void e_delete() {
    }

    @Test
    void d_getAll() {
        System.out.println("Get all:");
        System.out.println(service.getAll());
    }
}