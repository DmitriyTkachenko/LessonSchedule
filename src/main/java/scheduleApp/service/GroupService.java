package scheduleApp.service;

import scheduleApp.entity.Group;

import java.util.List;

public interface GroupService {
    List<Group> findAll();
    String getGroupName(Integer id);
    Group save(Group group);
    Group findGroupByName(String name);
    Group findGroupById(Integer id);
}
