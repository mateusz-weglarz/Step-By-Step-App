package pl.coderslab.StepByStepApp.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.StepByStepApp.entity.Activity;
import pl.coderslab.StepByStepApp.entity.User;
import pl.coderslab.StepByStepApp.security.CurrentUser;
import pl.coderslab.StepByStepApp.service.ActivityService;

@Controller
@RequestMapping("/api/activities")
public class CreateActivityController {

    public CreateActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    private final ActivityService activityService;

    @PostMapping
    public String createActivity(@AuthenticationPrincipal CurrentUser currentUser, @ModelAttribute("numberOfSteps") Integer numberOfSteps, Model model) {
        CreateActivityRequest request = new CreateActivityRequest(numberOfSteps, currentUser.getUser());
        Activity activity = activityService.createActivity(request);
        model.addAttribute("activityToShow", activity);
        return "activity/showActivity";
    }

    public static class CreateActivityRequest {
        public CreateActivityRequest(Integer numberOfSteps, User user) {
            this.numberOfSteps = numberOfSteps;
            this.user = user;
        }

        private final Integer numberOfSteps;
        private final User user;

        public Integer getNumberOfSteps() {
            return numberOfSteps;
        }

        public User getUser() {
            return user;
        }

    }

}
