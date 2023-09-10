package za.ac.cput.domain;

/* Driver.java
 Author: Lyle Esau (221431942)
 Date: 11 June 2023
*/

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Driver implements Serializable {

    @Id
    private String driverId;
    private String firstName;
    private String lastName;
    private String contact;
    private String email;
    private String driverPosition;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DeliveryVehicle> vehicles;

    public Driver() {
    }

    //builder constructor:
    private Driver(Builder builder){

        this.driverId = builder.driverId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.contact = builder.contact;
        this.email = builder.email;
        this.driverPosition = builder.driverPosition;
        this.vehicles = builder.vehicles;

    }

    public String getDriverId() {
        return driverId;
    }

    public String getFirstName() {
        return firstName;
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

    public String getDriverPosition() {
        return driverPosition;
    }

    public List<DeliveryVehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId='" + driverId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", driverPosition='" + driverPosition + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }

    public String secondString() {
        return "Driver{" +
                "driverId='" + driverId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", driverPosition='" + driverPosition + '\'' +
                '}';
    }

    public static class Builder{

        //attributes:
        private String driverId;
        private String firstName;
        private String lastName;
        private String contact;
        private String email;
        private String driverPosition;
        private List<DeliveryVehicle> vehicles;

        //setters:
        public Builder setDriverId(String driverId) {
            this.driverId = driverId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setContact(String contact) {
            this.contact = contact;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setDriverPosition(String driverPosition) {
            this.driverPosition = driverPosition;
            return this;
        }

        public Builder setVehicles(List<DeliveryVehicle> vehicles) {
            this.vehicles = vehicles;
            return this;
        }

        //copy:
        public Builder copy(Driver driver){

            this.driverId = driver.driverId;
            this.firstName = driver.firstName;
            this.lastName = driver.lastName;
            this.contact = driver.contact;
            this.email = driver.email;
            this.driverPosition = driver.driverPosition;
            this.vehicles = driver.vehicles;
            return this;
        }

        //build:
        public Driver build(){
            return new Driver(this);
        }

    }

}


