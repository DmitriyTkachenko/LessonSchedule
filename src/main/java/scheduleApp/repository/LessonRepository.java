package scheduleApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scheduleApp.entity.Group;
import scheduleApp.entity.Instructor;
import scheduleApp.entity.Lesson;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    List<Lesson> findByGroups(List<Group> groups);
    List<Lesson> findByInstructors(List<Instructor> instructors);
}
