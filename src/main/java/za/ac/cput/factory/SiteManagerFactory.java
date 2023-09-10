package za.ac.cput.factory;

import za.ac.cput.domain.Project;
import za.ac.cput.domain.SiteManager;

import java.util.List;

public class SiteManagerFactory {
    public static SiteManager createSiteManagerWithAttributes(
            String siteManagerId,
            String userPosition,
            String firstName,
            String middleName,
            String lastName,
            String contact,
            String email
    ) {
        return new SiteManager.SiteManagerBuilder()
                .setSiteManagerId(siteManagerId)
                .setPosition(userPosition)
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .setContact(contact)
                .setEmail(email)
                .build();
    }

    public static SiteManager createSiteManager(
            String siteManagerId,
            String userPosition,
            List<Project> projects
    ) {
        return new SiteManager.SiteManagerBuilder()
                .setSiteManagerId(siteManagerId)
                .setPosition(userPosition)
                .setProject(projects)
                .build();
    }

}
