package za.ac.cput.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.repository.SiteManagerRepository;
import za.ac.cput.service.SiteManagerService;

import java.io.Serializable;
import java.util.List;

@Service
public class SiteManagerServiceImpl implements SiteManagerService, Serializable {
    private final SiteManagerRepository repository;

    @Autowired
    private SiteManagerServiceImpl(SiteManagerRepository  repository) {
        this.repository=repository;

    }
    @Override
    public SiteManager create(SiteManager siteManager) {
        return this.repository.save(siteManager);

    }
    @Override
    public SiteManager read(String siteManagerID){
        return this.repository.findById(siteManagerID).orElse(null);

    }



    @Override
    public SiteManager update(SiteManager siteManager){
        if(this.repository.existsById(siteManager.getSiteManagerId()))
            return this.repository.save(siteManager);
        return null;
    }
    @Override
    public boolean delete(String siteManagerID){
        if (this.repository.existsById(siteManagerID)){
            this.repository.deleteById(siteManagerID);
            return true;
        }
        return false;
    }
    @Override
    public List<SiteManager> getAll(){
        return this.repository.findAll();
    }

}
