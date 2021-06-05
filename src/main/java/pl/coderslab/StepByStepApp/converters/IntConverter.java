package pl.coderslab.StepByStepApp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IntConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(String s) {
        return Integer.parseInt(s);
    }
}
