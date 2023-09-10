package za.ac.cput.factory;

import za.ac.cput.domain.Project;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.util.Helper;

import java.util.List;

public class ProjectManagerFactory {

    public static ProjectManager createProjectManagerWithAttributes(
            String projectManagerId,
            String position,
            String firstName,
            String middleName,
            String lastName,
            String contact,
            String email
    ) {  /*if(Helper.isNullOrEmpty(projectManagerId)||Helper.isNullOrEmpty(position)
            ||Helper.isNullOrEmpty(firstName)
            ||Helper.isNullOrEmpty(middleName)
            ||Helper.isNullOrEmpty(lastName)
            ||Helper.isNullOrEmpty(contact)
            ||Helper.isValidEmail(email))
    {

        return null;
    }*/
        return new ProjectManager.ProjectManagerBuilder()
                .setProjectManagerId(projectManagerId)
                .setPosition(position)
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setContact(contact)
                .setEmail(email)
                .build();
    }
    public static ProjectManager createProjectManagerWithProject(
            String projectManagerId,
            String position,
            String firstName,
            String middleName,
            String lastName,
            String contact,
            String email,
            List<Project> projects
    ) {
        /*{
            if (Helper.isNullOrEmpty(projectManagerId) || Helper.isNullOrEmpty(position)
                    || Helper.isNullOrEmpty(firstName)
                    || Helper.isNullOrEmpty(middleName)
                    || Helper.isNullOrEmpty(lastName)
                    || Helper.isNullOrEmpty(contact)
                    || Helper.isValidEmail(email)
                    || Helper.isNullOrEmpty(String.valueOf(projects))) {

                return null;
            }*/
            {
                return new ProjectManager.ProjectManagerBuilder()
                        .setProjectManagerId(projectManagerId)
                        .setPosition(position)
                        .setFirstName(firstName)
                        .setMiddleName(middleName)
                        .setLastName(lastName)
                        .setContact(contact)
                        .setEmail(email).setProject(projects)
                        .build();
            }

        }
    }




