package com.healthy.healthcheck;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class HealthcheckApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        servletContext.setInitParameter("spring.profiles.default","prod");
    }

}
