package scheduleApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLessons(ModelMap model) {
        model.addAttribute("auditorium", new Auditorium());
        model.addAttribute("course", new Course());
        model.addAttribute("group", new Group());
        model.addAttribute("instructor", new Instructor());

        model.addAttribute("lesson", new Lesson());

        model.addAttribute("courses", courseRepository.findAll());
        model.addAttribute("auditoriums", auditoriumRepository.findAll());
        model.addAttribute("groups", groupRepository.findAll());
        model.addAttribute("instructors", instructorRepository.findAll());
        model.addAttribute("daysOfWeek", DayOfWeek.values());
        model.addAttribute("numbers", Number.values());

        List<Lesson> lessonList = lessonRepository.findAll();

        Collections.sort(lessonList, new Comparator<Lesson>() {
            @Override
            public int compare(Lesson l1, Lesson l2) {
                int numberCmp = l1.getNumber().getValue() - l2.getNumber().getValue();
                if (numberCmp != 0) {
                    return numberCmp;
                }
                int dayOfWeekCmp = l1.getDayOfWeek().getValue() - l2.getDayOfWeek().getValue();
                return dayOfWeekCmp;
            }
        });

        model.addAttribute("lessons", lessonList);

        List<Lesson> lessonsForGroup = lessonRepository.findByGroupName("ДА-22");

        return "schedule";
    }

    @RequestMapping(value = "/addLesson", method = RequestMethod.POST)
    public String addLesson(@Valid @ModelAttribute("lesson") Lesson lesson, BindingResult result) {
        lessonRepository.save(lesson);
        return "redirect:/";
    }

    @RequestMapping(value = "/addAuditorium", method = RequestMethod.POST)
    public String addAuditorium(@ModelAttribute("auditorium") Auditorium auditorium, BindingResult result) {
        auditoriumRepository.save(auditorium);
        return "redirect:/";
    }

    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public String addCourse(@ModelAttribute("course") Course course, BindingResult result) {
        courseRepository.save(course);
        return "redirect:/";
    }

    @RequestMapping(value = "/addGroup", method = RequestMethod.POST)
    public String addGroup(@ModelAttribute("group") Group group, BindingResult result) {
        groupRepository.save(group);
        return "redirect:/";
    }

    @RequestMapping(value = "/addInstructor", method = RequestMethod.POST)
    public String addInstructor(@ModelAttribute("instructor") Instructor instructor, BindingResult result) {
        instructorRepository.save(instructor);
        return "redirect:/";
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