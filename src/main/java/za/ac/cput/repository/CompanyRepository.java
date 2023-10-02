package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
}
