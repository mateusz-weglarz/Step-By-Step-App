package pl.coderslab.StepByStepApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.StepByStepApp.entity.User;
import pl.coderslab.StepByStepApp.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomePageController {

    private final UserService userService;

    public HomePageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getHomePage(){
        return "homePage";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "registerUser";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult result, @RequestParam String button) {
        if (button.equals("save")) {
            if (result.hasErrors()) {
                return "registerUser";
            }
            userService.addNewUser(user);
            return "redirect:/login";
        }
        return "redirect:/";
    }

    @GetMapping("/contact")
    public String getContactPage(){
        return "contact";
    }

    @GetMapping("/top")
    public String getTopPage(Model model){
        List<User> topFiveUsers = userService.findTopFiveUsers();
        model.addAttribute("topUserList",topFiveUsers);
        return "top";
    }

    @GetMapping("/about")
    public String getAboutPage(){
        return "about";
    }

    @GetMapping("/logout")
    public String getLogoutPage(){
        return "logout";
    }
}
