package ru.ashabelskii.systemcontact.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import ru.ashabelskii.systemcontact.common.converter.ObjectIdConverter;


@Configuration
public class WebConfig implements WebFluxConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new ObjectIdConverter());
    }

}
