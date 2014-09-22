package scheduleApp.service;

import scheduleApp.entity.Group;
import scheduleApp.entity.Instructor;
import scheduleApp.entity.Lesson;
import scheduleApp.entity.enums.DayOfWeek;
import scheduleApp.entity.enums.LessonNumber;
import scheduleApp.entity.enums.LessonType;

import java.util.List;

public interface LessonService {
    List<Lesson> findAll();
    Lesson save(Lesson lesson);
    void delete(Integer id);
}
