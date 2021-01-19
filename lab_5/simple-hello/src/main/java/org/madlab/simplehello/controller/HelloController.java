package org.madlab.simplehello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Environment environment;

    @Autowired
    public HelloController(final Environment environment) {
        this.environment = environment;
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello: " + environment.getProperty("SPRING_USERNAME") + "\n";
    }

    @GetMapping(value = "/secret")
    public String secret() {
        return "As you can see, the secret has been decoded for you: " + environment.getProperty("SPRING_SECRET") + "\n";
    }

}
