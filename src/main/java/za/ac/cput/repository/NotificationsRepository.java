package za.ac.cput.repository;
/*
Student Number:221110933
Name & Surname : Jameelah Gallo
Date: updated the  10th September 2023
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Notifications;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, String> {

}
