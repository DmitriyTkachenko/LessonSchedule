package scheduleApp.service;

import scheduleApp.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course save(Course course);
}
