package scheduleApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LessonController {
//    @Autowired
//    private ConversionService conversionService;
////Autowiring the ConversionService we declared in the context file above.
//
//    @InitBinder
//    public void registerConversionServices(WebDataBinder dataBinder) {
//        dataBinder.setConversionService(conversionService);
//    }

    @Autowired
    private LessonRepository lessonRepository;

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
        model.addAttribute("lessons", lessonRepository.findAll());

        return "lessons";
    }

    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private InstructorRepository instructorRepository;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String listUsers(ModelMap model) {
//        model.addAttribute("user", new Lesson());
//        model.addAttribute("users", lessonRepository.findAll());
//        return "users";
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

//    @RequestMapping(value = "/chooseAuditorium", method = RequestMethod.POST)
//    public String chooseAuditorium(@ModelAttribute("auditorium") Auditorium auditorium) {
//        return "redirect:/";
//    }
//
    @RequestMapping(value = "/addLesson", method = RequestMethod.POST)
    public String addLesson(@ModelAttribute("lesson") @Valid Lesson lesson, BindingResult result) {
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

}