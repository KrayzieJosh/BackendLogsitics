package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "project_manager")
public class ProjectManager {
    @Id
    @Column(name = "projectManagerId")
    private String projectManagerId;

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

    private ProjectManager(ProjectManagerBuilder builder) {
        this.projectManagerId = builder.projectManagerId;
        this.position = builder.position;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
        this.contact = builder.contact;
        this.email = builder.email;
        this.project = builder.project;
    }

    public String getProjectManagerId() {
        return projectManagerId;
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
        return "ProjectManager{" +
                "projectManagerId='" + projectManagerId + '\'' +
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
        return "ProjectManager{" +
                "projectManagerId='" + projectManagerId + '\'' +
                ", position='" + position + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public ProjectManager(String projectManagerId, String position, String firstName, String middleName, String lastName, String contact, String email, List<Project> project) {
        this.projectManagerId = projectManagerId;
        this.position = position;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.contact = contact;
        this.email = email;
        this.project = project;
    }

    public ProjectManager() {
    }

    public ProjectManager(String projectManagerId, String position) {
        this.projectManagerId = projectManagerId;
        this.position = position;
    }

    public static class ProjectManagerBuilder {
        private String projectManagerId;
        private String position;
        private String firstName;
        private String middleName;
        private String lastName;
        private String contact;
        private String email;
        private List<Project> project;

        public ProjectManagerBuilder setProjectManagerId(String projectManagerId) {
            this.projectManagerId = projectManagerId;
            return this;
        }

        public ProjectManagerBuilder setPosition(String position) {
            this.position = position;
            return this;
        }

        public ProjectManagerBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ProjectManagerBuilder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public ProjectManagerBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ProjectManagerBuilder setContact(String contact) {
            this.contact = contact;
            return this;
        }

        public ProjectManagerBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public ProjectManagerBuilder setProject(List<Project> project) {
            this.project = project;
            return this;
        }

        public ProjectManagerBuilder copy(ProjectManager projectManager) {
            this.projectManagerId = projectManager.projectManagerId;
            this.position = projectManager.position;
            this.firstName = projectManager.firstName;
            this.middleName = projectManager.middleName;
            this.lastName = projectManager.lastName;
            this.contact = projectManager.contact;
            this.email = projectManager.email;
            this.project = projectManager.project;

            return this;
        }

        public ProjectManager build() {
            return new ProjectManager(this);
        }
    }}

