package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.DeliveryVehicle;

@Repository
public interface DeliveryVehicleRepository extends JpaRepository<DeliveryVehicle,String> {
}
