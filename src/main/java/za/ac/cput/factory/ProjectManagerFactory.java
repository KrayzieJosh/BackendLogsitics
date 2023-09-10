package za.ac.cput.factory;

import za.ac.cput.domain.Project;
import za.ac.cput.domain.ProjectManager;

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
    ) {
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


    public static ProjectManager createProjectManager(
            String projectManagerId,
            String position,
            List<Project> projects
    ) {
        return new ProjectManager.ProjectManagerBuilder()
                .setProjectManagerId(projectManagerId)
                .setPosition(position)
                .setProject(projects)
                .build();
    }}



