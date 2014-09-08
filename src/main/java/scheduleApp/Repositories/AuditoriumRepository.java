package scheduleApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import scheduleApp.Model.Auditorium;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {

}