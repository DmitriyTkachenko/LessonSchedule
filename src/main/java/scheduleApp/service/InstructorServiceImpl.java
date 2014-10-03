package scheduleApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scheduleApp.entity.Instructor;
import scheduleApp.repository.InstructorRepository;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    public String getInstructorName(Integer id) {
        return instructorRepository.findOne(id).getName();
    }

    @Override
    public Instructor save(Instructor instructor) {
        try {
            return instructorRepository.save(instructor);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Instructor findInstructorByName(String name) {
        return instructorRepository.findInstructorByName(name);
    }

    @Override
    public Instructor findInstructorById(Integer id) {
        return instructorRepository.findInstructorById(id);
    }
}
