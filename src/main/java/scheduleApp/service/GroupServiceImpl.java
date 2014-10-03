package scheduleApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scheduleApp.entity.Group;
import scheduleApp.repository.GroupRepository;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public String getGroupName(Integer id) {
        return groupRepository.findOne(id).getName();
    }

    @Override
    public Group save(Group group) {
        try {
            return groupRepository.save(group);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Group findGroupByName(String name) {
        return groupRepository.findGroupByName(name);
    }

    @Override
    public Group findGroupById(Integer id) {
        return groupRepository.findGroupById(id);
    }
}
