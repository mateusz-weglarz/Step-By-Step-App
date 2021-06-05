package pl.coderslab.StepByStepApp.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.StepByStepApp.entity.User;
import pl.coderslab.StepByStepApp.service.UserService;

public class UserConverter implements Converter<String, User> {

    @Autowired
    private UserService userService;

    @Override
    public User convert(String s) {
        return userService.findUserById(Long.parseLong(s));
    }
}
