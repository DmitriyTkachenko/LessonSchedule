package scheduleApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import scheduleApp.entity.Lesson;
import scheduleApp.service.GroupService;
import scheduleApp.service.InstructorService;

import java.util.List;

@RestController
public class ScheduleRestController {

    @Autowired
    InstructorService instructorService;

    @Autowired
    GroupService groupService;

    @RequestMapping(value = "/api/schedule/group/", method = RequestMethod.GET)
    public List<Lesson> getLessonsForGroup(@RequestParam("name") String name) {
        return groupService.findGroupByName(name).getLessons();
    }

    @RequestMapping(value = "/api/schedule/instructor/", method = RequestMethod.GET)
    public List<Lesson> getLessonsForInstructor(@RequestParam("name") String name) {
        return instructorService.findInstructorByName(name).getLessons();
    }

}
