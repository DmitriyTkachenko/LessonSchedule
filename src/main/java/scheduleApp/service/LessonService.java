package scheduleApp.service;

import scheduleApp.entity.Group;
import scheduleApp.entity.Instructor;
import scheduleApp.entity.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> findAll();
    Lesson save(Lesson lesson);
    void delete(Integer id);
    List<Lesson> findByGroups(List<Group> groups);
    List<Lesson> findByInstructors(List<Instructor> instructors);
}
