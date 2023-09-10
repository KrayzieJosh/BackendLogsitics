package za.ac.cput.service;

import za.ac.cput.domain.ProjectManager;

import java.util.List;

public interface ProjectManagerService {
    ProjectManager create(ProjectManager projectManager);

    ProjectManager read(String projectManagerID);

    ProjectManager update(ProjectManager projectManager);

    boolean delete(String projectManagerID);

    List<ProjectManager> getAll();
}
