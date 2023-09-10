package za.ac.cput.service;

import za.ac.cput.domain.SiteManager;

import java.util.List;

public interface SiteManagerService {
    SiteManager create(SiteManager siteManager);

    SiteManager read(String siteManagerID);

    SiteManager update(SiteManager siteManager);

    boolean delete(String siteManagerID);

    List<SiteManager> getAll();
}
