package scheduleApp.service;

import scheduleApp.entity.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> findAll();
    Lesson save(Lesson lesson);
    List<Lesson> findByGroupId(Integer groupId);
    List<Lesson> findByInstructorId(Integer instructorId);
    void delete(Integer id);
}
