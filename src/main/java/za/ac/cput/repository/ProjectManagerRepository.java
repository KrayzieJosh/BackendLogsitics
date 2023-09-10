package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.ProjectManager;

public interface ProjectManagerRepository  extends JpaRepository<ProjectManager,String> {
}
