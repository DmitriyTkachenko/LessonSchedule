package scheduleApp.service;

import scheduleApp.entity.Auditorium;

import java.util.List;

public interface AuditoriumService {
    List<Auditorium> findAll();
    Auditorium save(Auditorium auditorium);
}
