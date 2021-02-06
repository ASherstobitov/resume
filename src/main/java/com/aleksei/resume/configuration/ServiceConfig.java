package com.aleksei.resume.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan({"com.aleksei.resume.service.impl",
        "com.aleksei.resume.controller",
        "com.aleksei.resume.filter",
        "com.aleksei.resume.listener",
        })
public class ServiceConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocations(getResources());
        return configurer;
    }

    private static Resource[] getResources() {
        return new Resource[] {new ClassPathResource("application.properties")};
    }
}
