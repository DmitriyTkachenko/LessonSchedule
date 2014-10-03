package scheduleApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scheduleApp.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
}
