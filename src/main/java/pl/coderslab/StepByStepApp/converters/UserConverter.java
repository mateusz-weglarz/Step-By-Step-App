package pl.coderslab.StepByStepApp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.StepByStepApp.entity.User;
import pl.coderslab.StepByStepApp.service.UserService;

@Component
public class UserConverter implements Converter<String, User> {

    private final UserService userService;

    public UserConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User convert(String s) {
        return userService.findUserById(Long.parseLong(s));
    }
}
