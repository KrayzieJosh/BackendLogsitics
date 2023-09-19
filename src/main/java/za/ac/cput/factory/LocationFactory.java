package za.ac.cput.factory;

import za.ac.cput.util.Helper;
import za.ac.cput.domain.Location;

public class LocationFactory {
    public static Location createLocation(String locationId, String name, int streetNumber, String streetName, String townOrCity, int areaCode) {
        locationId = Helper.generateID();
        if ((Helper.isNullOrEmpty(locationId) || Helper.isNullOrEmpty(name) || streetNumber <= 0 || Helper.isNullOrEmpty(streetName) || Helper.isNullOrEmpty(townOrCity) || areaCode <= 0)) {
            return null;
        }
        Location location = new Location(locationId, name, streetNumber, streetName, townOrCity, areaCode);
        return new Location.Builder(location)
                .setLocationId(locationId)
                .setName(name)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setTownOrCity(townOrCity)
                .setAreaCode(areaCode)
                .build();
    }
}
