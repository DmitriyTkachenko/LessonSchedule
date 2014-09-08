package scheduleApp.Formatters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import scheduleApp.Model.Auditorium;
import scheduleApp.Repositories.AuditoriumRepository;

import java.text.ParseException;
import java.util.Locale;

@Component
public class AuditoriumFormatter implements Formatter<Auditorium> {
    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Override
    public String print(Auditorium auditorium, Locale arg1) {
        return auditorium.toString();
    }

    @Override
    public Auditorium parse(String id, Locale arg1) throws ParseException {
        return auditoriumRepository.findOne(Long.parseLong(id));
    }
}