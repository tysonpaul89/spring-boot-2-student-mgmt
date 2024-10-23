package com.student.management;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s";

    @GetMapping("/greet")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format(template,name);
    }

}
