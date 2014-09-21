package scheduleApp;

import java.util.List;

public interface GroupService {
    List<Group> getGroupAsList(Integer id);
    String getGroupName(Integer id);
}
