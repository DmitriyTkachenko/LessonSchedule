package scheduleApp;

import java.util.List;

public interface InstructorService {
    List<Instructor> getInstructorAsList(Integer id);
    String getInstructorName(Integer id);
}
