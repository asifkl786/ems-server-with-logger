package com.ems.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// Purpose of this class Expose /uploads/** as static URL for accessing images publicly

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:///C:/Users/Asif Khan/Documents/workspace-spring-tool-suite-4-4.25.0.RELEASE/ems-server/uploads/");
    }
}

