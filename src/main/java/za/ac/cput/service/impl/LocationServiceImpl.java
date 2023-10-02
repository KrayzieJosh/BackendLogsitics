package za.ac.cput.service.impl;

/* LocationServiceImpl.java
 Entities for the serviceImpl
 Author: Joshua Jacobs (221144862)
 Date: 9 June 2023
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Location;
import za.ac.cput.repository.LocationRepository;
import za.ac.cput.service.LocationService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository repository;

    @Autowired
    public LocationServiceImpl(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Location create(Location location) {
        return repository.save(location);
    }

    @Override
    public Location read(String locationId) {
        Optional<Location> optionalLocation = repository.findById(locationId);
        return optionalLocation.orElse(null);
    }

    @Override
    public Location update(Location location) {
        // Assume you have an existing Location object
        Location existingLocation = this.repository.findById(location.getLocationId()).orElse(null);

        if (existingLocation != null) {
            // Use the builder's setter methods to create an updated Location
            Location updatedLocation = new Location.Builder(existingLocation)
                    .setName(location.getName())
                    .setStreetNumber(location.getStreetNumber())
                    .setStreetName(location.getStreetName())
                    .setTownOrCity(location.getTownOrCity())
                    .setAreaCode(location.getAreaCode())
                    .build();

            // Update the location using the repository
            return this.repository.save(updatedLocation);
        }

        return null; // Location not found
    }


    @Override
    public boolean delete(String locationId) {
        if (repository.existsById(locationId)) {
            repository.deleteById(locationId);
            return true;
        }
        return false;
    }

    @Override
    public Set<Location> getAll() {
        List<Location> locationList = repository.findAll();
        return new HashSet<>(locationList);
    }
}
