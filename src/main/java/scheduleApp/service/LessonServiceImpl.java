package scheduleApp.service;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scheduleApp.entity.Lesson;
import scheduleApp.repository.GroupRepository;
import scheduleApp.repository.InstructorRepository;
import scheduleApp.repository.LessonRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LessonServiceImpl implements LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public List<Lesson> findByGroupId(Integer groupId) {
        List<Lesson> lessons = groupRepository.findGroupById(groupId).getLessons();
        Hibernate.initialize(lessons);
        return lessons;
    }

    @Override
    public List<Lesson> findByInstructorId(Integer instructorId) {
        List<Lesson> lessons = instructorRepository.findInstructorById(instructorId).getLessons();
        Hibernate.initialize(lessons);
        return lessons;
    }

    @Override
    public void delete(Integer id) {
        lessonRepository.delete(id);
    }

}
