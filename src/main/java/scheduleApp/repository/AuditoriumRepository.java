package scheduleApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scheduleApp.entity.Auditorium;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Integer> {

}