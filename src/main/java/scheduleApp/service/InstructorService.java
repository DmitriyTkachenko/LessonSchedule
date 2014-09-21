package scheduleApp.service;

import scheduleApp.entity.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getInstructorAsList(Integer id);
    List<Instructor> findAll();
    String getInstructorName(Integer id);
    Instructor save(Instructor instructor);
    Instructor findInstructorByName(String name);
}
