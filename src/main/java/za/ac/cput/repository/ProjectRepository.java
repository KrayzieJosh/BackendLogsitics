package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,String> {

}