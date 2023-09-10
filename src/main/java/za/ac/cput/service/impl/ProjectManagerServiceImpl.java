package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.repository.ProjectManagerRepository;
import za.ac.cput.service.ProjectManagerService;

import java.io.Serializable;
import java.util.List;

@Service
public class ProjectManagerServiceImpl implements ProjectManagerService, Serializable {
    private final ProjectManagerRepository repository;

    @Autowired
    private ProjectManagerServiceImpl(ProjectManagerRepository  repository) {
        this.repository=repository;

    }
    @Override
    public ProjectManager create(ProjectManager projectManager) {
        return this.repository.save(projectManager);

    }
    @Override
    public ProjectManager read(String projectManagerID){
        return this.repository.findById(projectManagerID).orElse(null);

    }



    @Override
    public ProjectManager update(ProjectManager projectManager){
        if(this.repository.existsById(projectManager.getProjectManagerId()))
            return this.repository.save(projectManager);
        return null;
    }
    @Override
    public boolean delete(String projectManagerID){
        if (this.repository.existsById(projectManagerID)){
            this.repository.deleteById(projectManagerID);
            return true;
        }
        return false;
    }
    @Override
    public List<ProjectManager> getAll(){
        return this.repository.findAll();
    }

}
