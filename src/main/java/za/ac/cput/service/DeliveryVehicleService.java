package za.ac.cput.service;
import za.ac.cput.domain.DeliveryVehicle;
import java.util.List;
public interface DeliveryVehicleService {
    DeliveryVehicle create(DeliveryVehicle deliveryVehicle);
    DeliveryVehicle read(String vehicleId);
    DeliveryVehicle update(DeliveryVehicle deliveryVehicle);
    boolean delete (String vehicleId);
    public List<DeliveryVehicle> getAll();
}
