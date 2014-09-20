package scheduleApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> getInstructorAsList(Integer id) {
        List<Instructor> list = new ArrayList<>();
        Instructor instructor = instructorRepository.findOne(id);
        list.add(instructor);
        return list;
    }

    public String getInstructorName(Integer id) {
        return instructorRepository.findOne(id).getName();
    }
}
