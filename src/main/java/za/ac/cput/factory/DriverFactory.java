package za.ac.cput.factory;

import za.ac.cput.domain.DeliveryVehicle;
import za.ac.cput.domain.Driver;
import za.ac.cput.util.Helper;

import java.util.List;

public class DriverFactory {

    public static Driver createNewDriverWithVehicles(String firstName, String lastName, String contact, String email, String driverPosition, List<DeliveryVehicle> vehicles){

        if(Helper.isStringNullOrEmpty(firstName) || Helper.isStringNullOrEmpty(lastName)){
            return null;
        }

        if(Helper.isStringNullOrEmpty(contact) || Helper.isStringNullOrEmpty(driverPosition)){
            return null;
        }

        if (!Helper.isValidEmail(email)){
            return null;
        }

        if (Helper.isListNullOrEmpty(vehicles)){
            return null;
        }

        String driverId = Helper.generateID();

        return new Driver.Builder()
                .setDriverId(driverId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setContact(contact)
                .setEmail(email)
                .setDriverPosition(driverPosition)
                .setVehicles(vehicles)
                .build();
    }

    public static Driver createNewDriver(String firstName, String lastName, String contact, String email, String driverPosition){

        if(Helper.isStringNullOrEmpty(firstName) || Helper.isStringNullOrEmpty(lastName)){
            return null;
        }

        if(Helper.isStringNullOrEmpty(contact) || Helper.isStringNullOrEmpty(driverPosition)){
            return null;
        }

        if (!Helper.isValidEmail(email)){
            return null;
        }

        String driverId = Helper.generateID();

        return new Driver.Builder()
                .setDriverId(driverId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setContact(contact)
                .setEmail(email)
                .setDriverPosition(driverPosition)
                .build();
    }

}

