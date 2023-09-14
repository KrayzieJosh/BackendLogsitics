package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Tracking;

import java.util.Set;
@Repository
public interface TrackingRepository extends JpaRepository<Tracking,String> {
}
