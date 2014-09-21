package scheduleApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scheduleApp.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    Group findGroupByName(String name);
    Group findGroupById(Integer id);
}