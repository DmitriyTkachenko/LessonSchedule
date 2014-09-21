package scheduleApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scheduleApp.entity.Auditorium;
import scheduleApp.repository.AuditoriumRepository;

import java.util.List;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {
    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Override
    public List<Auditorium> findAll() {
        return auditoriumRepository.findAll();
    }

    @Override
    public Auditorium save(Auditorium auditorium) {
        try {
            return auditoriumRepository.save(auditorium);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
