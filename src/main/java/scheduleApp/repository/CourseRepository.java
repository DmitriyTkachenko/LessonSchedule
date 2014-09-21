package scheduleApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scheduleApp.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}