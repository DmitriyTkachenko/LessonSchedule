package scheduleApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import scheduleApp.Model.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

}
