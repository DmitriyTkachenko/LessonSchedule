package scheduleApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@EnableJpaRepositories
public class ScheduleController {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private GroupService groupService;

    @Autowired
    private InstructorService instructorService;

    private Comparator<Lesson> lessonComparator = new Comparator<Lesson>() {
        @Override
        public int compare(Lesson l1, Lesson l2) {
            int numberCmp = l1.getNumber().getValue() - l2.getNumber().getValue();
            if (numberCmp != 0) {
                return numberCmp;
            }
            int dayOfWeekCmp = l1.getDayOfWeek().getValue() - l2.getDayOfWeek().getValue();
            return dayOfWeekCmp;
        }
    };

    private List<Lesson> lessonList = new ArrayList<>();

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public String showSchedule(@RequestParam(value = "groupId", required = false) Integer groupId, @RequestParam(value = "instructorId", required = false) Integer instructorId, ModelMap model) {
        return "schedule";
    }

    @RequestMapping(value = "/schedule/group/{groupId}/", method = RequestMethod.GET)
    public String showScheduleForGroup(@PathVariable("groupId") Integer groupId, ModelMap model) {
        prepareForEditing(model);
        lessonList = lessonRepository.findByGroups(groupService.getGroupAsList(groupId));
        Collections.sort(lessonList, lessonComparator);
        model.addAttribute("lessons", lessonList);
        model.addAttribute("mode", "group");
        model.addAttribute("id", groupId);
        model.addAttribute("name", groupService.getGroupName(groupId));
        return "schedule";
    }

    @RequestMapping(value = "/schedule/instructor/{instructorId}/", method = RequestMethod.GET)
    public String showScheduleForInstructor(@PathVariable("instructorId") Integer instructorId, ModelMap model) {
        prepareForEditing(model);
        lessonList = lessonRepository.findByInstructors(instructorService.getInstructorAsList(instructorId));
        Collections.sort(lessonList, lessonComparator);
        model.addAttribute("lessons", lessonList);
        model.addAttribute("mode", "instructor");
        model.addAttribute("id", instructorId);
        model.addAttribute("name", instructorService.getInstructorName(instructorId));
        return "schedule";
    }

    public void prepareForEditing(ModelMap model) {
        // for input forms
        model.addAttribute("auditorium", new Auditorium());
        model.addAttribute("course", new Course());
        model.addAttribute("group", new Group());
        model.addAttribute("instructor", new Instructor());
        model.addAttribute("lesson", new Lesson());

        // for constructing Lesson through select
        model.addAttribute("courses", courseRepository.findAll());
        model.addAttribute("auditoriums", auditoriumRepository.findAll());
        model.addAttribute("groups", groupRepository.findAll());
        model.addAttribute("instructors", instructorRepository.findAll());
        model.addAttribute("daysOfWeek", DayOfWeek.values());
        model.addAttribute("numbers", Number.values());
    }

    @RequestMapping(value = "/schedule/group/{groupId}/delete/{lessonId}/")
    public String deleteLesson(@PathVariable("lessonId") Integer lessonId, @PathVariable("groupId") Integer groupId, HttpServletRequest request) {
        lessonRepository.delete(lessonId);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = "/schedule/*/*/addLesson", method = RequestMethod.POST)
    public String addLesson(@Valid @ModelAttribute("lesson") Lesson lesson, BindingResult result, HttpServletRequest request) {
        lessonRepository.save(lesson);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = "/schedule/*/*/addAuditorium", method = RequestMethod.POST)
    public String addAuditorium(@ModelAttribute("auditorium") Auditorium auditorium, BindingResult result, HttpServletRequest request) {
        auditoriumRepository.save(auditorium);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = "/schedule/*/*/addCourse", method = RequestMethod.POST)
    public String addCourse(@ModelAttribute("course") Course course, BindingResult result, HttpServletRequest request) {
        courseRepository.save(course);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = "/schedule/*/*/addGroup", method = RequestMethod.POST)
    public String addGroup(@ModelAttribute("group") Group group, BindingResult result, HttpServletRequest request) {
        groupRepository.save(group);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = "/schedule/*/*/addInstructor", method = RequestMethod.POST)
    public String addInstructor(@ModelAttribute("instructor") Instructor instructor, BindingResult result, HttpServletRequest request) {
        instructorRepository.save(instructor);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

//    @RequestMapping("/delete/{userId}")
//    public String deleteUser(@PathVariable("userId") Long userId) {
//        lessonRepository.delete(lessonRepository.findOne(userId));
//        return "redirect:/";
//    }

    //    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
//    public
//    @ResponseBody
//    String listUsersJson(ModelMap model) throws JSONException {
//        JSONArray userArray = new JSONArray();
//        for (Lesson user : lessonRepository.findAll()) {
//            JSONObject userJSON = new JSONObject();
//            userJSON.put("id", user.getId());
//            userJSON.put("firstName", user.getFirstName());
//            userJSON.put("lastName", user.getLastName());
//            userJSON.put("email", user.getEmail());
//            userArray.put(userJSON);
//        }
//        return userArray.toString();
//    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public String addUser(@ModelAttribute("user") User user, BindingResult result) {
//        userRepository.save(user);
//        return "redirect:/";
//    }

}