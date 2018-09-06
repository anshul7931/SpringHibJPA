package com.example.demo.configs;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.example.demo.controllers.UserController;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
    	register(UserController.class);
    }
}
