package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.DeliveryVehicle;
import za.ac.cput.service.DeliveryVehicleService;
import java.util.List;

@RestController
@RequestMapping("/deliveryVehicle")
public class DeliveryVehicleController {
    @Autowired
    private DeliveryVehicleService deliveryVehicleService;

    @PostMapping("/create")
    public DeliveryVehicle create(@RequestBody DeliveryVehicle deliveryVehicle) {
        return deliveryVehicleService.create(deliveryVehicle);
    }

    @GetMapping("/read/{vehicleId}")
    public DeliveryVehicle read(@PathVariable String vehicleId) {
        return deliveryVehicleService.read(vehicleId);
    }

    @PostMapping("/update")
    public DeliveryVehicle update(@RequestBody DeliveryVehicle deliveryVehicle) {
        return deliveryVehicleService.update(deliveryVehicle);
    }

    @DeleteMapping("delete/{vehicleId}")
    public boolean delete(@PathVariable String vehicleId) {
        return deliveryVehicleService.delete(vehicleId);
    }

    @GetMapping("/getall")
    public List<DeliveryVehicle> getAll() {

        return deliveryVehicleService.getAll();
    }
}
