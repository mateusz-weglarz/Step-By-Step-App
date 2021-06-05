package pl.coderslab.StepByStepApp.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.StepByStepApp.entity.Activity;
import pl.coderslab.StepByStepApp.security.CurrentUser;
import pl.coderslab.StepByStepApp.service.ActivityService;
import pl.coderslab.StepByStepApp.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/activity")
public class ActivityController {

    private final ActivityService activityService;
    private final UserService userService;

    public ActivityController(ActivityService activityService, UserService userService) {
        this.activityService = activityService;
        this.userService = userService;
    }

    @GetMapping("/edit/{activityId}")
    public String editActivity(Model model, @PathVariable Long activityId, @AuthenticationPrincipal CurrentUser currentUser) {
        Activity activityById = activityService.findActivityById(activityId);
        if (!activityById.getUser().getId().equals(currentUser.getUser().getId())) {
            return "redirect:/user/activities";
        }
        model.addAttribute("activityToEdit", activityById);
        return "activity/edit";
    }

    @PostMapping("/edit")
    public String editActivityPerform(@Valid @ModelAttribute("activityToEdit") Activity activity, BindingResult result, @RequestParam String button, @AuthenticationPrincipal CurrentUser currentUser) {
        if (!activity.getUser().getId().equals(currentUser.getUser().getId())) {
            return "redirect:/user/activities";
        }
        if (button.equals("save")) {
            if (result.hasErrors()) {
                System.out.println(result);
                return "activity/edit";
            }
            activityService.updateActivity(activity);
        }
        return "redirect:/user/activities";
    }

    @GetMapping("/delete/{activityId}")
    public String deleteActivity(Model model, @PathVariable Long activityId, @AuthenticationPrincipal CurrentUser currentUser) {
        Activity activityById = activityService.findActivityById(activityId);
        if (!activityById.getUser().getId().equals(currentUser.getUser().getId())) {
            return "redirect:/user/activities";
        }
        model.addAttribute("activityToDelete", activityById);
        return "activity/delete";
    }

    @PostMapping("/delete/{activityId}")
    public String deleteActivityPerform(@RequestParam String confirm, @PathVariable Long activityId, @AuthenticationPrincipal CurrentUser currentUser) {
        Activity activityById = activityService.findActivityById(activityId);
        if (!activityById.getUser().getId().equals(currentUser.getUser().getId())) {
            return "redirect:/user/activities";
        }
        if (confirm.equals("delete")) {
            activityService.deleteActivity(activityId);
        }
        return "redirect:/user/activities";
    }

    @GetMapping("/show/{activityId}")
    public String showActivity(Model model, @PathVariable Long activityId,@AuthenticationPrincipal CurrentUser currentUser) {
        Activity activityToShow = activityService.findActivityById(activityId);
        if(!activityToShow.getUser().getId().equals(currentUser.getUser().getId())){
            return "redirect:/user/activities";
        }
        model.addAttribute("activityToShow",activityToShow);
        return "activity/show";
    }

    //TODO:Dodać aktywność przesłaną z telefonu
}
