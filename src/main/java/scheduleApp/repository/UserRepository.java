package scheduleApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import scheduleApp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByLogin(String login);
}
