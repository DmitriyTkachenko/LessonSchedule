package scheduleApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scheduleApp.entity.Group;
import scheduleApp.entity.Instructor;
import scheduleApp.entity.Lesson;
import scheduleApp.repository.LessonRepository;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public void delete(Integer id) {
        lessonRepository.delete(id);
    }

    @Override
    public List<Lesson> findByGroups(List<Group> groups) {
        return lessonRepository.findByGroups(groups);
    }

    @Override
    public List<Lesson> findByInstructors(List<Instructor> instructors) {
        return lessonRepository.findByInstructors(instructors);
    }
}
