package scheduleApp.service;

import scheduleApp.entity.User;

public interface UserService {
    User getUser(String login);
}