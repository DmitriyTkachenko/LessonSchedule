package scheduleApp.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import scheduleApp.entity.Auditorium;
import scheduleApp.repository.AuditoriumRepository;

import java.text.ParseException;
import java.util.Locale;

@Component("auditoriumFormatter")
public class AuditoriumFormatter implements Formatter<Auditorium> {
    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Override
    public String print(Auditorium auditorium, Locale arg1) {
        return auditorium.toString();
    }

    @Override
    public Auditorium parse(String id, Locale arg1) throws ParseException {
        return auditoriumRepository.findOne(Integer.parseInt(id));
    }
}