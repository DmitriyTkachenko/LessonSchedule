package scheduleApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

    @SuppressWarnings("SameReturnValue")
    @RequestMapping(method = RequestMethod.GET)
    public String showLoginPage(Model model){
        return "login";
    }

}