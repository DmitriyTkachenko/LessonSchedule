package scheduleApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scheduleApp.entity.Group;
import scheduleApp.repository.GroupRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getGroupAsList(Integer id) {
        List<Group> list = new ArrayList<>();
        Group group = groupRepository.findOne(id);
        list.add(group);
        return list;
    }

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public String getGroupName(Integer id) {
        return groupRepository.findOne(id).getName();
    }

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group findGroupByName(String name) {
        return groupRepository.findGroupByName(name);
    }
}
