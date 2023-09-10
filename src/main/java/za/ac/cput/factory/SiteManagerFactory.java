package za.ac.cput.factory;

import za.ac.cput.domain.Project;
import za.ac.cput.domain.SiteManager;
import za.ac.cput.util.Helper;

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
    ) {  if(Helper.isNullOrEmpty(siteManagerId)||Helper.isNullOrEmpty(userPosition)
            ||Helper.isNullOrEmpty(firstName)
            ||Helper.isNullOrEmpty(middleName)
            ||Helper.isNullOrEmpty(lastName)
            ||Helper.isNullOrEmpty(contact)
            ||Helper.isValidEmail(email))
    {

        return null;
    }{
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



}}
