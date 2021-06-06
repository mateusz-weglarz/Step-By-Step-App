package pl.coderslab.StepByStepApp.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.StepByStepApp.entity.Group;
import pl.coderslab.StepByStepApp.security.CurrentUser;
import pl.coderslab.StepByStepApp.service.GroupService;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/user/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/list")
    public String getUserGroups(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("groupList", groupService.findGroupsByUserId(currentUser.getUser().getId()));
        return "groups/userGroups";
    }

    @GetMapping("/all")
    public String getAllGroups(Model model) {
        model.addAttribute("groupList", groupService.findAllGroups());
        return "groups/allGroups";
    }

    @GetMapping("/add-group")
    public String addNewGroup(Model model) {
        Group group = new Group();
        model.addAttribute("group", group);
        return "groups/addNewGroup";
    }

    @PostMapping("/add-group")
    public String addNewGroupPerform(@Valid Group group, BindingResult result, @RequestParam String button, @AuthenticationPrincipal CurrentUser currentUser) {
        if (button.equals("save")) {
            if (result.hasErrors()) {
                return "groups/addNewGroup";
            }
            groupService.addNewGroup(group, currentUser.getUser());
            return "redirect:/user/groups/list";
        }
        return "redirect:/user/groups/list";
    }

    @GetMapping("/find")
    public String searchForGroup(Model model) {
        Group group = new Group();
        model.addAttribute("group", group);
        return "groups/search";
    }

    @GetMapping("/search-result")
    public String searchForGroupPerform(Model model, @Valid Group group, BindingResult result, @RequestParam String button, @AuthenticationPrincipal CurrentUser currentUser) {
        if (button.equals("search")) {
            if (result.hasErrors()) {
                return "groups/search";
            }
            Group groupByName = groupService.findGroupByName(group.getName());
            model.addAttribute("group", groupByName);
            if (groupService.checkIfUserBelongToGroup(currentUser.getUser(), groupByName)) {
                return "groups/showGroupDetails";
            }
            return "groups/showGroupGenerall";
        }
        return "redirect:/user/groups/list";
    }

    @GetMapping("/details/{groupId}")
    public String getDetailsOfGroup(@PathVariable Long groupId, Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        Group groupToShow = groupService.findGroupById(groupId);
        if (groupService.checkIfUserBelongToGroup(currentUser.getUser(), groupToShow)) {
            model.addAttribute("group", groupToShow);
            return "groups/showGroupDetails";
        }
        return "403";
    }
}

