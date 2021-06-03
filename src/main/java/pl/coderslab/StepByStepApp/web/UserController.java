package pl.coderslab.StepByStepApp.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.StepByStepApp.entity.User;
import pl.coderslab.StepByStepApp.service.ActivityService;
import pl.coderslab.StepByStepApp.service.UserService;

import javax.validation.Valid;


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

    @GetMapping("/activities/{userId}")
    public String getUserActivities(Model model,@PathVariable Long userId) {
        model.addAttribute("userActivities", activityService.findAllActivitiesForUser(userId));
        return "user/activities";
    }

    @GetMapping("/dashboard")
    public String getUserDashboard() {
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
