package scheduleApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import scheduleApp.Model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {

}