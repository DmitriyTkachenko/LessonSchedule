package scheduleApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scheduleApp.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
    Instructor findInstructorByName(String name);
}
