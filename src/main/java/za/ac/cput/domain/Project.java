package za.ac.cput.domain;
import jakarta.persistence.*;
@Entity
public class Project {
    @Id
    private String projectId;
    private String projectName;
    private String projectStatus;
    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "driver",referencedColumnName = "driverId")
    private Driver driver;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "project_manager_id",referencedColumnName = "projectManagerId")
    private ProjectManager projectManager;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="site_manager_id",referencedColumnName = "siteManagerId")
    private SiteManager siteManager;


    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="delivery_order_id",referencedColumnName = "deliveryOrderId")
    private DeliveryOrder deliveryOrder;


    public Project() {
    }

    public Project(String projectId, String projectName, String projectStatus, Driver driver, ProjectManager projectManager,
                   SiteManager siteManager,  DeliveryOrder deliveryOrder) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectStatus = projectStatus;
        this.driver = driver;
        this.projectManager = projectManager;
        this.siteManager = siteManager;

        this.deliveryOrder = deliveryOrder;
    }



    private Project(ProjectBuilder projectBuilder){
        this.projectId = projectBuilder.projectId;
        this.projectName = projectBuilder.projectName;
        this.projectStatus = projectBuilder.projectStatus;
        this.projectManager=projectBuilder.projectManager;
        this.siteManager=projectBuilder.siteManager;
        this.driver=projectBuilder.driver;

        this.deliveryOrder=projectBuilder.deliveryOrder;

    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public ProjectManager getProjectManager() {

        return projectManager;
    }

    public SiteManager getSiteManager() {return siteManager;}


    public Driver getDriver() {
        return driver;
    }

    public DeliveryOrder getDeliveryOrder(){return deliveryOrder;}


    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectStatus='" + projectStatus + '\'' +
                ", driver=" + driver +
                ", projectManager=" + projectManager +
                ", siteManager=" + siteManager +


                ",DeliveryOrder="+deliveryOrder+
                '}';
    }

//custom string just to display the project details and excludes project manager & site manager
    public String secondString(){
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectStatus='" + projectStatus + '}';

    }
    public static class ProjectBuilder {
        private String projectId;
        private String projectName;
        private String projectStatus;
        private ProjectManager projectManager;
        private SiteManager siteManager;
        private Driver driver;
        private DeliveryOrder deliveryOrder;

        public ProjectBuilder setProjectId(String projectId) {
            this.projectId = projectId;
            return this;
        }

        public ProjectBuilder setProjectName(String projectName) {
            this.projectName = projectName;
            return this;
        }

        public ProjectBuilder setProjectStatus(String projectStatus) {
            this.projectStatus = projectStatus;
            return this;
        }

        public ProjectBuilder setProjectManager(ProjectManager projectManager) {
            this.projectManager = projectManager;
            return this;
        }

        public ProjectBuilder setSiteManager(SiteManager siteManager) {
            this.siteManager = siteManager;
            return this;

        }
        public ProjectBuilder setDriver(Driver driver) {
            this.driver = driver;
            return this;
        }



        public ProjectBuilder setDeliveryOrder(DeliveryOrder deliveryOrder){
            this.deliveryOrder=deliveryOrder;
            return this;
        }
        public Project.ProjectBuilder copy(Project project){
            this.projectId=project.projectId;
            this.projectName=project.projectName;
            this.projectStatus=project.projectStatus;
            this.projectManager=project.projectManager;
            this.siteManager=project.siteManager;
            this.driver=project.driver;

            this.deliveryOrder=project.deliveryOrder;


           return this;
        }
        public Project build(){
            return new Project(this);

        }
    }
}
