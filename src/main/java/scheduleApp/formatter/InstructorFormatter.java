package scheduleApp.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import scheduleApp.entity.Instructor;
import scheduleApp.repository.InstructorRepository;

import java.text.ParseException;
import java.util.Locale;

@Component("instructorFormatter")
public class InstructorFormatter implements Formatter<Instructor> {
    @Autowired
    private InstructorRepository instructorRepository;

    @Override
    public String print(Instructor instructor, Locale arg1) {
        return instructor.toString();
    }

    @Override
    public Instructor parse(String id, Locale arg1) throws ParseException {
        return instructorRepository.findOne(Integer.parseInt(id));
    }
}