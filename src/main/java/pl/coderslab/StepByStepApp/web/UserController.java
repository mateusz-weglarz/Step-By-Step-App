package pl.coderslab.StepByStepApp.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.StepByStepApp.security.CurrentUser;
import pl.coderslab.StepByStepApp.service.ActivityService;
import pl.coderslab.StepByStepApp.service.UserService;



@Controller
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;
    private final ActivityService activityService;

    @Autowired
    public UserController(UserService userService, ActivityService activityService) {
        this.userService = userService;
        this.activityService = activityService;
    }

    @GetMapping("/activities")
    public String getUserActivities(@AuthenticationPrincipal CurrentUser currentUser,Model model) {
        model.addAttribute("userActivities", activityService.findAllActivitiesForUser(currentUser.getUser().getId()));
        return "user/activities";
    }

    @GetMapping("/dashboard")
    public String getUserDashboard(@AuthenticationPrincipal CurrentUser currentUser,Model model) {
        model.addAttribute("userFirstname", currentUser.getUser().getFirstName());
        return "user/dashboard";
    }

    @GetMapping("/account")
    public String getUserAccount() {
        return "user/account";
    }

    @GetMapping("/friends")
    public String getUserFriends() {
        return "user/friends";
    }

    @GetMapping("/goals")
    public String getUserGoals() {
        return "user/goals";
    }

    @GetMapping("/groups")
    public String getUserGroups() {
        return "user/groups";
    }

}
