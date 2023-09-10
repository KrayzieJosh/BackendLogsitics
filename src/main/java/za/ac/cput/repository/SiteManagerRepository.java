package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.SiteManager;

public interface SiteManagerRepository  extends JpaRepository<SiteManager,String> {
}
