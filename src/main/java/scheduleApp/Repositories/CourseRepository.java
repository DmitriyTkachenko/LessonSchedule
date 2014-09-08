package scheduleApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import scheduleApp.Model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}