package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;

@EntityScan
@Entity
public class GPS implements Serializable {
    @Id
    private String tripId;
    private String startLocationId;
    private String storeLocationId;

    private GPS (GPS.Builder builder){
        this.tripId = builder.tripId;
        this.startLocationId = builder.startLocationId;
        this.storeLocationId = builder.storeLocationId;
    }

    public String getTripId() {
        return tripId;
    }

    public String getStartLocationId() {
        return startLocationId;
    }

    public String getStoreLocationId() {
        return storeLocationId;
    }

    @Override
    public String toString() {
        return "GPS{" +
                "tripId='" + tripId + '\'' +
                ", startLocationId='" + startLocationId + '\'' +
                ", storeLocationId='" + storeLocationId + '\'' +
                '}';
    }

    public GPS(String tripId, String startLocationId, String storeLocationId) {
        this.tripId = tripId;
        this.startLocationId = startLocationId;
        this.storeLocationId = storeLocationId;
    }

    public GPS() {
    }

    public static class Builder{
        private String tripId;
        private String startLocationId;
        private String storeLocationId;

        public Builder setTripId(String tripId) {
            this.tripId = tripId;
            return this;
        }

        public Builder setStartLocationId(String startLocationId) {
            this.startLocationId = startLocationId;
            return this;
        }

        public Builder setStoreLocationId(String storeLocationId) {
            this.storeLocationId = storeLocationId;
            return this;
        }
        public Builder copy(GPS gps){
            this.tripId = tripId;
            this.startLocationId = startLocationId;
            this.storeLocationId = storeLocationId;
            return this;
        }
        public GPS build(){return new GPS(this);}
    }
}
