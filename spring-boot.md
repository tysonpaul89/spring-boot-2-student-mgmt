# Maven Commands

To install dependencies from pom.xml file

``` bash
mvn install
```

It clears out the existing classes that compiled from last compile. This will not remove the installed dependencies

``` bash
mvn clean
```

Prints a tree representation of your project dependencies

``` bash
mvn dependency:tree
```

# Spring Boot 2

Click here for the [spring boot 2 documentation](https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/getting-started-first-application.html)

``` java
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
```

**@RestController** annotation automatically converts your JavaBeans into JSON or XML. It combines @Controller with @ResponseBody into a single descriptive annotation.

**@GetMapping** annotation is used for routing, it will route HTTP GET request to /greet path to this ```greeting``` method. We can also use **@RequestMapping** which will route all the HTTP verbs(POST, GET, PUT, and DELETE) to the given method.

