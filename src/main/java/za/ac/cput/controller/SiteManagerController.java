package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.service.SiteManagerService;

import java.util.List;

@RestController
@RequestMapping("/siteManager")
public class SiteManagerController {
    @Autowired
    private SiteManagerService siteManagerService;
    @PostMapping("/create")
    public SiteManager create(@RequestBody SiteManager siteManager){
        return siteManagerService.create(siteManager);

    }  @GetMapping("/read/{siteManagerID}")
    public SiteManager read(@PathVariable String siteManagerID)
    {

        return siteManagerService.read(siteManagerID);
    }
    @PostMapping("/update")
    public SiteManager update(@RequestBody SiteManager siteManager){
        return siteManagerService.update(siteManager);

    }
    @DeleteMapping("/delete/{siteManagerID}")
    public boolean delete(@PathVariable String siteManagerID){
        return siteManagerService.delete(siteManagerID);

    }
    @GetMapping("/getall")
    public List<SiteManager> getAll(){
        return siteManagerService.getAll();
    }

}

