package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "project_manager")
public class ProjectManager {
    @Id
    private String projectManagerId;

    @Column(name = "position")
    private String position;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Project> project;

    private ProjectManager(ProjectManagerBuilder builder) {
        this.projectManagerId = builder.projectManagerId;
        this.position = builder.position;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
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


    public String getLastName() {
        return lastName;
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
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", project=" + project +
                '}';
    }

    public String secondString() {
        return "ProjectManager{" +
                "projectManagerId='" + projectManagerId + '\'' +
                ", position='" + position + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }



    public ProjectManager(String projectManagerId, String position, String firstName, String lastName, String email, List<Project> project) {
        this.projectManagerId = projectManagerId;
        this.position = position;
        this.firstName = firstName;
        this.lastName = lastName;
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
        private String lastName;
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


        public ProjectManagerBuilder setLastName(String lastName) {
            this.lastName = lastName;
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
            this.lastName = projectManager.lastName;
            this.email = projectManager.email;
            this.project = projectManager.project;

            return this;
        }

        public ProjectManager build() {
            return new ProjectManager(this);
        }
    }}

