package za.ac.cput.domain;
/*
Student Number:221110933
Name & Surname : Jameelah Gallo
Date: updated the  10th September 2023
 */
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Notifications {
    @Id
    private String notificationId;
    private String notificationMessage;
    private String notificationStatus;

    private Notifications(Builder builder) {
        this.notificationId = builder.notificationId;
        this.notificationMessage =builder.notificationMessage;
        this.notificationStatus = builder.notificationStatus;
    }

    protected Notifications() {

    }

    public String getNotificationId() {
        return notificationId;
    }

    public String getNotificationMessage() {
        return notificationMessage;
    }

    public String getNotificationStatus() {
        return notificationStatus;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", notificationMessage='" + notificationMessage + '\'' +
                ", notificationStatus='" + notificationStatus + '\'' +
                '}';
    }

    public static class Builder{
        private String notificationId;
        private String notificationMessage;
        private String notificationStatus;

        public Builder setNotificationId(String notificationId) {
            this.notificationId = notificationId;
            return this;
        }

        public Builder setNotificationMessage(String notificationMessage) {
            this.notificationMessage = notificationMessage;
            return this;
        }

        public Builder setNotificationStatus(String notificationStatus) {
            this.notificationStatus = notificationStatus;
            return this;
        }

        public Builder copy(Notifications notification){
            this.notificationId = notification.notificationId;
            this.notificationMessage = notification.notificationMessage;
            this.notificationStatus = notification.notificationStatus;
            return this;
        }
        public Notifications build(){
            return new Notifications(this);
        }
    }
}




