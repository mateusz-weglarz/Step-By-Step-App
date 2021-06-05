package pl.coderslab.StepByStepApp.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.StepByStepApp.entity.User;
import pl.coderslab.StepByStepApp.security.CurrentUser;
import pl.coderslab.StepByStepApp.service.UserService;
import pl.coderslab.StepByStepApp.vidators.ValidationPassword;
import pl.coderslab.StepByStepApp.vidators.ValidationUserDetails;


@Controller
@RequestMapping(path = "/user/account")
public class AccountController {

    private final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/show")
    public String getUserAccount(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("user", userService.findUserById(currentUser.getUser().getId()));
        return "user/account";
    }

    @GetMapping("/edit-account")
    public String editUserAccountDetails(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("user", userService.findUserById(currentUser.getUser().getId()));
        return "account/edit-details";
    }

    @PostMapping("/edit-account")
    public String editUserAccountDetailsPerform(@Validated({ValidationUserDetails.class}) User user, BindingResult result, @AuthenticationPrincipal CurrentUser currentUser, @RequestParam String button) {
        if (!user.getId().equals(currentUser.getUser().getId())) {
            return "redirect:/user/account/show";
        }
        if (button.equals("save")) {
            if (result.hasErrors()) {
                return "account/edit-details";
            }
            userService.updateUser(user);
        }
        return "redirect:/user/account/show";
    }

    @GetMapping("/edit-password")
    public String editUserPassword(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("user", userService.findUserById(currentUser.getUser().getId()));
        return "account/edit-password";
    }

    @PostMapping("/edit-password")
    public String editUserPasswordPerform(@Validated({ValidationPassword.class}) User user, BindingResult result, @AuthenticationPrincipal CurrentUser currentUser, @RequestParam String button) {
        if (!user.getId().equals(currentUser.getUser().getId())) {
            return "redirect:/user/account/show";
        }
        if (button.equals("save")) {
            if (result.hasErrors()) {
                return "account/edit-password";
            }
            userService.updateUserPassword(user);
        }
        return "redirect:/user/account/show";
    }

    @GetMapping("/delete")
    public String deleteUserAccount(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("userToDelete", userService.findUserById(currentUser.getUser().getId()));
        return "account/deleteAccount";
    }

    @GetMapping("/confirm-delete")
    public String confirmDeleteAccount(@RequestParam String button) {
        if (button.equals("delete")) {
            return "account/confirmDeleteAccount";
        }
        return "redirect:/user/account/show";
    }

    @PostMapping("/delete")
    public String deleteUserAccountPerform(@AuthenticationPrincipal CurrentUser currentUser, @RequestParam String button) {
        if (button.equals("delete")) {
            userService.deleteUser(currentUser.getUser().getId());
        }
        return "redirect:/";
    }
}

