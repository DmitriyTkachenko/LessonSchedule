package scheduleApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import scheduleApp.form.GroupSearchForm;
import scheduleApp.form.InstructorSearchForm;
import scheduleApp.service.GroupService;
import scheduleApp.service.InstructorService;

import javax.validation.Valid;

@Controller
@EnableJpaRepositories
public class SearchController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private InstructorService instructorService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndexPage(ModelMap model) {
        model.addAttribute("groups", groupService.findAll());
        model.addAttribute("instructors", instructorService.findAll());
        model.addAttribute("groupSearchForm", new GroupSearchForm());
        model.addAttribute("instructorSearchForm", new InstructorSearchForm());
        return "index";
    }

    @RequestMapping(value = "/showScheduleForGroup", method = RequestMethod.POST)
    public String showScheduleForGroup(@Valid @ModelAttribute("groupSearchForm") GroupSearchForm groupSearchForm, BindingResult result) {
        return "redirect:/schedule/group/" + groupSearchForm.getGroup().getId() + "/";
    }

    @RequestMapping(value = "/showScheduleForInstructor", method = RequestMethod.POST)
    public String showScheduleForInstructor(@Valid @ModelAttribute("instructorSearchForm") InstructorSearchForm instructorSearchForm, BindingResult result) {
        return "redirect:/schedule/instructor/" + instructorSearchForm.getInstructor().getId() + "/";
    }
}
