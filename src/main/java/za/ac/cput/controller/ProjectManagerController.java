package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.ProjectManager;
import za.ac.cput.service.ProjectManagerService;

import java.util.List;

@RestController
@RequestMapping("/projectManager")
public class ProjectManagerController {
    @Autowired
    private ProjectManagerService projectManagerService;
    @PostMapping("/create")
    public ProjectManager create(@RequestBody ProjectManager projectManager){
        return projectManagerService.create(projectManager);

    }  @GetMapping("/read/{projectManagerID}")
    public ProjectManager read(@PathVariable String projectManagerID)
    {

        return projectManagerService.read(projectManagerID);
    }
    @PostMapping("/update")
    public ProjectManager update(@RequestBody ProjectManager projectManager){
        return projectManagerService.update(projectManager);

    }
    @DeleteMapping("/delete/{projectManagerID}")
    public boolean delete(@PathVariable String projectManagerID){
        return projectManagerService.delete(projectManagerID);

    }
    @GetMapping("/getall")
    public List<ProjectManager> getAll(){
        return projectManagerService.getAll();
    }

}
