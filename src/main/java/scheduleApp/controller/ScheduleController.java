package scheduleApp.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import scheduleApp.entity.enums.LessonNumber;
import scheduleApp.entity.*;
import scheduleApp.entity.enums.DayOfWeek;
import scheduleApp.repository.*;
import scheduleApp.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

@Controller
@EnableJpaRepositories
public class ScheduleController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private AuditoriumService auditoriumService;

    @Autowired
    private CourseService courseService;

    private Comparator<Lesson> lessonComparator = new Comparator<Lesson>() {
        @Override
        public int compare(Lesson l1, Lesson l2) {
            int numberCmp = l1.getLessonNumber().getValue() - l2.getLessonNumber().getValue();
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
        prepareForEditing(model);
        return "schedule";
    }

    @RequestMapping(value = "/schedule/group/{groupId}/", method = RequestMethod.GET)
    public String showScheduleForGroup(@PathVariable("groupId") Integer groupId, ModelMap model, HttpServletRequest request) {
        model.addAttribute("daysOfWeek", DayOfWeek.values());
        model.addAttribute("lessonNumbers", LessonNumber.values());
        if (request.isUserInRole("EDITOR") || request.isUserInRole("ADMIN")) {
            prepareForEditing(model);
        }
        lessonList = lessonService.findByGroups(groupService.getGroupAsList(groupId));
        Collections.sort(lessonList, lessonComparator);
        model.addAttribute("lessons", lessonList);
        model.addAttribute("mode", "group");
        model.addAttribute("name", groupService.getGroupName(groupId));
        return "schedule";
    }

    @RequestMapping(value = "/schedule/instructor/{instructorId}/", method = RequestMethod.GET)
    public String showScheduleForInstructor(@PathVariable("instructorId") Integer instructorId, ModelMap model, HttpServletRequest request) {
        model.addAttribute("daysOfWeek", DayOfWeek.values());
        model.addAttribute("lessonNumbers", LessonNumber.values());
        if (request.isUserInRole("EDITOR") || request.isUserInRole("ADMIN")) {
            prepareForEditing(model);
        }
        lessonList = lessonService.findByInstructors(instructorService.getInstructorAsList(instructorId));
        Collections.sort(lessonList, lessonComparator);
        model.addAttribute("lessons", lessonList);
        model.addAttribute("mode", "instructor");
        model.addAttribute("name", instructorService.getInstructorName(instructorId));
        return "schedule";
    }

    @PreAuthorize("hasRole('EDITOR') or hasRole('ADMIN')")
    public void prepareForEditing(ModelMap model) {
        // for input forms
        model.addAttribute("auditorium", new Auditorium());
        model.addAttribute("course", new Course());
        model.addAttribute("group", new Group());
        model.addAttribute("instructor", new Instructor());
        model.addAttribute("lesson", new Lesson());

        // for constructing Lesson through select
        model.addAttribute("courses", courseService.findAll());
        model.addAttribute("auditoriums", auditoriumService.findAll());
        model.addAttribute("groups", groupService.findAll());
        model.addAttribute("instructors", instructorService.findAll());
    }

    @RequestMapping(value = "**/delete/{lessonId}/")
    @PreAuthorize("hasRole('EDITOR') or hasRole('ADMIN')")
    public String deleteLesson(@PathVariable("lessonId") Integer lessonId, HttpServletRequest request) {
        lessonService.delete(lessonId);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = "**/addLesson", method = RequestMethod.POST)
    @PreAuthorize("hasRole('EDITOR') or hasRole('ADMIN')")
    public String addLesson(@Valid @ModelAttribute("lesson") Lesson lesson, BindingResult result, HttpServletRequest request) {
        lessonService.save(lesson);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = "**/addAuditorium", method = RequestMethod.POST)
    @PreAuthorize("hasRole('EDITOR') or hasRole('ADMIN')")
    public String addAuditorium(@ModelAttribute("auditorium") Auditorium auditorium, BindingResult result, HttpServletRequest request) {
        auditoriumService.save(auditorium);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = "**/addCourse", method = RequestMethod.POST)
    @PreAuthorize("hasRole('EDITOR') or hasRole('ADMIN')")
    public String addCourse(@ModelAttribute("course") Course course, BindingResult result, HttpServletRequest request) {
        courseService.save(course);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = "**/addGroup", method = RequestMethod.POST)
    @PreAuthorize("hasRole('EDITOR') or hasRole('ADMIN')")
    public String addGroup(@ModelAttribute("group") Group group, BindingResult result, HttpServletRequest request) {
        groupService.save(group);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = "**/addInstructor", method = RequestMethod.POST)
    @PreAuthorize("hasRole('EDITOR') or hasRole('ADMIN')")
    public String addInstructor(@ModelAttribute("instructor") Instructor instructor, BindingResult result, HttpServletRequest request) {
        instructorService.save(instructor);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = "/api/group/", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    String listLessonsForGroupJson(@RequestParam("groupName") String groupName, ModelMap model) throws JSONException {
        Group group = groupService.findGroupByName(groupName);
        JSONArray lessonArray = new JSONArray();
        for (Lesson lesson : group.getLessons()) {
            JSONObject lessonJSON = new JSONObject();
            lessonJSON.put("course", lesson.getCourse().getName());
            lessonJSON.put("instructors", lesson.getInstructorsString());
            lessonJSON.put("auditoriums", lesson.getAuditoriumsString());
            lessonJSON.put("type", lesson.getLessonType().getDisplayName());
            lessonJSON.put("number", lesson.getLessonNumber().getDisplayName());
            lessonJSON.put("dayOfWeek", lesson.getDayOfWeek().getDisplayName());
            lessonArray.put(lessonJSON);
        }
        return lessonArray.toString();
    }

    @RequestMapping(value = "/api/instructor/", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    String listLessonsForInstructorJson(@RequestParam("instructorName") String instructorName, ModelMap model) throws JSONException {
        Instructor instructor = instructorService.findInstructorByName(instructorName);
        JSONArray lessonArray = new JSONArray();
        for (Lesson lesson : instructor.getLessons()) {
            JSONObject lessonJSON = new JSONObject();
            lessonJSON.put("course", lesson.getCourse().getName());
            lessonJSON.put("groups", lesson.getGroupsString());
            lessonJSON.put("instructors", lesson.getInstructorsString());
            lessonJSON.put("auditoriums", lesson.getAuditoriumsString());
            lessonJSON.put("type", lesson.getLessonType().getDisplayName());
            lessonJSON.put("number", lesson.getLessonNumber().getDisplayName());
            lessonJSON.put("dayOfWeek", lesson.getDayOfWeek().getDisplayName());
            lessonArray.put(lessonJSON);
        }
        return lessonArray.toString();
    }

/*    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public
    @ResponseBody
    String listUsersJson(ModelMap model) throws JSONException {
        JSONArray userArray = new JSONArray();
        for (User user : userRepository.findAll()) {
            JSONObject userJSON = new JSONObject();
            userJSON.put("id", user.getId());
            userJSON.put("firstName", user.getFirstName());
            userJSON.put("lastName", user.getLastName());
            userJSON.put("email", user.getEmail());
            userArray.put(userJSON);
        }
        return userArray.toString();
    }*/
}