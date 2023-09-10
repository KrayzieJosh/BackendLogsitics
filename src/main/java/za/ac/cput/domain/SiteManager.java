package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "site_manager", schema = "")
public class SiteManager {

    @Id
    private String siteManagerId;

    @Column(name = "position")
    private String position;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "contact")
    private String contact;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Project> project;

    private SiteManager(SiteManagerBuilder builder) {
        this.siteManagerId = builder.siteManagerId;
        this.position = builder.position;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.contact = builder.contact;
        this.email = builder.email;
        this.project = builder.project;
    }

    public String getSiteManagerId() {
        return siteManagerId;
    }

    public String getPosition() {
        return position;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public List<Project> getProject() {
        return project;
    }

    @Override
    public String toString() {
        return "SiteManager{" +
                "siteManagerId='" + siteManagerId + '\'' +
                ", position='" + position + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", project=" + project +
                '}';
    }
    public String secondString() {
        return "SiteManager{" +
                "siteManagerId='" + siteManagerId + '\'' +
                ", position='" + position + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public SiteManager(String siteManagerId, String position, String firstName, String middleName, String lastName, String contact, String email, List<Project> project) {
        this.siteManagerId = siteManagerId;
        this.position = position;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.contact = contact;
        this.email = email;
        this.project = project;
    }

    public SiteManager() {
    }

    public static class SiteManagerBuilder {
        private String siteManagerId;
        private String position;
        private String firstName;
        private String middleName;
        private String lastName;
        private String contact;
        private String email;
        private List<Project> project;

        public SiteManagerBuilder setSiteManagerId(String siteManagerId) {
            this.siteManagerId = siteManagerId;
            return this;
        }

        public SiteManagerBuilder setPosition(String position) {
            this.position = position;
            return this;
        }

        public SiteManagerBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public SiteManagerBuilder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public SiteManagerBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public SiteManagerBuilder setContact(String contact) {
            this.contact = contact;
            return this;
        }

        public SiteManagerBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public SiteManagerBuilder setProject(List<Project> project) {
            this.project = project;
            return this;
        }

        public SiteManagerBuilder copy(SiteManager siteManager) {
            this.siteManagerId = siteManager.siteManagerId;
            this.position = siteManager.position;
            this.firstName = siteManager.firstName;
            this.middleName = siteManager.middleName;
            this.lastName = siteManager.lastName;
            this.contact = siteManager.contact;
            this.email = siteManager.email;
            this.project = siteManager.project;
            return this;
        }

        public SiteManager build() {
            return new SiteManager(this);
        }
    }
}
