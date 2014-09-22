package scheduleApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scheduleApp.entity.Group;
import scheduleApp.entity.Instructor;
import scheduleApp.entity.Lesson;
import scheduleApp.entity.enums.DayOfWeek;
import scheduleApp.entity.enums.LessonNumber;
import scheduleApp.entity.enums.LessonType;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
}
