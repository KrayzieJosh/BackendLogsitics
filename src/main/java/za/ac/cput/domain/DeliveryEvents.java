package za.ac.cput.domain;
/*
Student Number:221110933
Name & Surname : Jameelah Gallo
Date: updated the  10th September 2023
 */
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class DeliveryEvents {
    @Id
    private String deliveryEventId;
    private String deliveryName;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime deliveryDate;
    private int streetNumber;
    private String streetName;
    private String townOrCity;
    private int areaCode;


    private DeliveryEvents (Builder builder){

        this.deliveryEventId = builder.deliveryEventId;
        this.deliveryName = builder.deliveryName;
        this.deliveryDate = builder.deliveryDate;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.townOrCity = builder.townOrCity;
        this.areaCode = builder.areaCode;


    }

    protected DeliveryEvents() {

    }

    public String getDeliveryEventId() {
        return deliveryEventId;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getTownOrCity() {
        return townOrCity;
    }

    public int getAreaCode() {
        return areaCode;
    }

    @Override
    public String toString() {
        return "DeliveryEvents{" +
                "deliveryEventId='" + deliveryEventId + '\'' +
                ", deliveryName='" + deliveryName + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", streetNumber=" + streetNumber +
                ", streetName='" + streetName + '\'' +
                ", townOrCity='" + townOrCity + '\'' +
                ", areaCode=" + areaCode +
                '}';
    }

    public static class Builder {

        private String deliveryEventId;
        private String deliveryName;
        private LocalDateTime deliveryDate;
        private int streetNumber;
        private String streetName;
        private String townOrCity;
        private int areaCode;


        public Builder setDeliveryEventId(String deliveryEventId) {
            this.deliveryEventId = deliveryEventId;
            return this;
        }

        public Builder setDeliveryName(String deliveryName) {
            this.deliveryName = deliveryName;
            return this;

        }

        public Builder setDeliveryDate(LocalDateTime deliveryDate) {
            this.deliveryDate = deliveryDate;
            return this;

        }

        public Builder setStreetNumber(int streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;

        }

        public Builder setTownOrCity(String townOrCity) {
            this.townOrCity = townOrCity;
            return this;

        }

        public Builder setAreaCode(int areaCode) {
            this.areaCode = areaCode;
            return this;

        }

        public Builder copy(DeliveryEvents deliveryEvent){

            this.deliveryEventId = deliveryEvent.deliveryEventId;
            this.deliveryName = deliveryEvent.deliveryName;
            this.deliveryDate = deliveryEvent.deliveryDate;
            this.streetNumber = deliveryEvent.streetNumber;
            this.streetName = deliveryEvent.streetName;
            this.townOrCity = deliveryEvent.townOrCity;
            this.areaCode = deliveryEvent.areaCode;
            return this;
        }
        public DeliveryEvents build(){
            return new DeliveryEvents(this);

        }
    }
}
