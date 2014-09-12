package scheduleApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import scheduleApp.CourseRepository;
import scheduleApp.Course;

import java.text.ParseException;
import java.util.Locale;

@Component("courseFormatter")
public class CourseFormatter implements Formatter<Course> {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public String print(Course course, Locale arg1) {
        return course.getName();
    }

    @Override
    public Course parse(String id, Locale arg1) throws ParseException {
        return courseRepository.findOne(Integer.parseInt(id));
    }
}