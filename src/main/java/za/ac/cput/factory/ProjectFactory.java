package za.ac.cput.factory;
import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

public class ProjectFactory {
    public static Project createProject(String projectId, String projectName, String projectStatus, ProjectManager projectManager, SiteManager siteManager, Driver driver, Company company){
        projectId = Helper.generateID();
        if(Helper.isNullOrEmpty(projectId)||Helper.isNullOrEmpty(projectName)||Helper.isNullOrEmpty(projectStatus)||Helper.isNullOrEmpty(String.valueOf(projectManager))||Helper.isNullOrEmpty(String.valueOf(siteManager))
                ||Helper.isNullOrEmpty(String.valueOf(driver))|| Helper.isNullOrEmpty(String.valueOf(company))){

            return null;
        }
        return new Project.ProjectBuilder()
                .setProjectId(projectId)
                .setProjectName(projectName)
                .setProjectStatus(projectStatus)
                .setProjectManager( projectManager)
                .setSiteManager(siteManager)
                .setDriver(driver)
                .setCompany(company)
                .build();


    }
    public static Project createProjectDetails(String projectId,String projectName, String projectStatus){

        if(Helper.isNullOrEmpty(projectId)||Helper.isNullOrEmpty(projectName)||Helper.isNullOrEmpty(projectStatus)){

            return null;
        }
        return new Project.ProjectBuilder()
                .setProjectId(projectId)
                .setProjectName(projectName)
                .setProjectStatus(projectStatus)
                .build();


    }
}