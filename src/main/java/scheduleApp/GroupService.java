package scheduleApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getGroupAsList(Integer id) {
        List<Group> list = new ArrayList<>();
        Group group = groupRepository.findOne(id);
        list.add(group);
        return list;
    }
}
