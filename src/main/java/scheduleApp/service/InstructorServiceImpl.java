package scheduleApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scheduleApp.entity.Instructor;
import scheduleApp.repository.InstructorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> getInstructorAsList(Integer id) {
        List<Instructor> list = new ArrayList<>();
        Instructor instructor = instructorRepository.findOne(id);
        list.add(instructor);
        return list;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    public String getInstructorName(Integer id) {
        return instructorRepository.findOne(id).getName();
    }

    @Override
    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @Override
    public Instructor findInstructorByName(String name) {
        return instructorRepository.findInstructorByName(name);
    }
}
