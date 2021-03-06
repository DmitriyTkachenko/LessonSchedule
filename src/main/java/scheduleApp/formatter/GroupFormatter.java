package scheduleApp.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import scheduleApp.entity.Group;
import scheduleApp.repository.GroupRepository;

import java.text.ParseException;
import java.util.Locale;

@Component("groupFormatter")
public class GroupFormatter implements Formatter<Group> {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public String print(Group group, Locale arg1) {
        return group.toString();
    }

    @Override
    public Group parse(String id, Locale arg1) throws ParseException {
        return groupRepository.findOne(Integer.parseInt(id));
    }
}