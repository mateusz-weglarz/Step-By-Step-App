package pl.coderslab.StepByStepApp.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.StepByStepApp.entity.Activity;
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
        model.addAttribute("group", groupToShow);
        if (groupService.checkIfUserBelongToGroup(currentUser.getUser(), groupToShow)) {
            return "groups/showGroupDetails";
        }
        return "groups/showGroupGenerall";
    }

    @GetMapping("/edit/{groupId}")
    public String editGroup(@PathVariable Long groupId, Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        Group groupById = groupService.findGroupById(groupId);
        if (groupById.getGroupAdminId().equals(currentUser.getUser().getId())) {
            model.addAttribute("group", groupById);
            return "groups/editGroup";
        }
        return "403";
    }

    @PostMapping("/edit")
    public String editGroupPerform(@Valid Group group, BindingResult result, @RequestParam String button, @AuthenticationPrincipal CurrentUser currentUser) {
        if (!group.getGroupAdminId().equals(currentUser.getUser().getId())) {
            return "403";
        }
        if (button.equals("save")) {
            if (result.hasErrors()) {
                return "groups/editGroup";
            }
            groupService.updateGroup(group);
        }
        return "redirect:/user/groups/list";
    }

    @GetMapping("/delete/{groupId}")
    public String deleteGroup(Model model, @PathVariable Long groupId, @AuthenticationPrincipal CurrentUser currentUser) {
        Group groupById = groupService.findGroupById(groupId);
        if (groupById.getGroupAdminId().equals(currentUser.getUser().getId())) {
            model.addAttribute("groupToDelete", groupById);
            return "groups/deleteGroup";
        }
        return "403";
    }

    @PostMapping("/delete/{groupId}")
    public String deleteGroupPerform(@RequestParam String button, @PathVariable Long groupId, @AuthenticationPrincipal CurrentUser currentUser) {
        Group groupById = groupService.findGroupById(groupId);
        if (groupById.getGroupAdminId().equals(currentUser.getUser().getId())) {
            if (button.equals("delete")) {
                groupService.deleteGroup(groupById.getId());
            }
            return "redirect:/user/groups/list";
        }
        return "403";
    }
}

