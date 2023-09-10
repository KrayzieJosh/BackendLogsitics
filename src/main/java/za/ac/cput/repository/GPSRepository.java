package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.GPS;

import java.util.Set;
@Repository
public interface GPSRepository extends JpaRepository<GPS,String> {
}
