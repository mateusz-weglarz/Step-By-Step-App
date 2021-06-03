package pl.coderslab.StepByStepApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.StepByStepApp.entity.Activity;
import pl.coderslab.StepByStepApp.service.ActivityService;

import javax.validation.Valid;

@Controller
@RequestMapping("/activity")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/edit/{activityId}")
    public String editActivity(Model model, @PathVariable Long activityId) {
        model.addAttribute("activityToEdit", activityService.findActivityById(activityId));
        return "activity/edit";
    }

    @PostMapping("/edit")
    public String editActivityPerform(@Valid Activity activity, BindingResult result, @RequestParam String button) {
        if (button.equals("save")) {
            if (result.hasErrors()) {
                return "activity/edit";
            }
            activityService.updateActivity(activity);
        }
        return "redirect:/user/activities/{userID}";
    }

    @GetMapping("/delete/{activityId}")
    public String deleteActivity(Model model, @PathVariable Long activityId) {
        model.addAttribute("activityToDelete", activityService.findActivityById(activityId));
        return "activity/delete";
    }

    @PostMapping("/delete")
    public String deleteActivityPerform(@Valid Activity activity,BindingResult result,@RequestParam String confirm){
        if(confirm.equals("delete")){
            if (result.hasErrors()){
                return "activity/delete";
            }
            activityService.deleteActivity(activity.getId());
        }
        return "redirect:/user/activities/{userID}";
    }

    @GetMapping("/show/{activityId}")
    public String showActivity(Model model, @PathVariable Long activityId){
        model.addAttribute("activityToShow",activityService.findActivityById(activityId));
        return "activity/show";
    }

    //TODO:Dodać aktywność przesłaną z telefonu
}
