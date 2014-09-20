package scheduleApp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    List<Lesson> findByGroups(List<Group> groups);
    List<Lesson> findByInstructors(List<Instructor> instructors);
}
