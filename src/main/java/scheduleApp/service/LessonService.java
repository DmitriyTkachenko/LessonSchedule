package scheduleApp.service;

import scheduleApp.entity.Lesson;

import java.util.List;

public interface LessonService {
    List<Lesson> findAll();
    Lesson save(Lesson lesson);
    void delete(Integer id);
}
