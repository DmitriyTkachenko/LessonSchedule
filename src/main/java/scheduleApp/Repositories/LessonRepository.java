package scheduleApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import scheduleApp.Model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
