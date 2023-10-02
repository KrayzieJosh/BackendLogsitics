package za.ac.cput.factory;

import za.ac.cput.domain.Company;
import za.ac.cput.domain.Project;
import za.ac.cput.util.Helper;

import java.util.List;

public class CompanyFactory {
public static Company createCompany(String companyId, String companyName, String companyPhysicalAddress,
                                    String companyEmail, List<Project> projects)
{
    companyId = Helper.generateID();
if(Helper.isNullOrEmpty(companyName)|| Helper.isNullOrEmpty(companyPhysicalAddress)||Helper.isNullOrEmpty(companyEmail)||
Helper.isNullOrEmpty(String.valueOf(projects))){

return null;
}
return new Company.Builder()
        .setCompanyId(companyId)
        .setCompanyName(companyName)
        .setCompanyPhysicalAddress(companyPhysicalAddress)
        .setCompanyEmail(companyEmail)
        .setProjects(projects)
        .build();


}
    public static Company createCompanyWithoutProject(String companyId, String companyName, String companyPhysicalAddress,
                                        String companyEmail)
    {
        companyId = Helper.generateID();
        if(Helper.isNullOrEmpty(companyName)|| Helper.isNullOrEmpty(companyPhysicalAddress)||Helper.isNullOrEmpty(companyEmail)
                ){

            return null;
        }
        return new Company.Builder()
                .setCompanyId(companyId)
                .setCompanyName(companyName)
                .setCompanyPhysicalAddress(companyPhysicalAddress)
                .setCompanyEmail(companyEmail)
                .build();


    }
}
