package com.student.management;

import java.util.UUID;

public class Student {
    private String name; // <-- Private property.

    private final String id; // <-- Declared as final so that it can be assigned only once and never modified

    public Student(String id, String name) { // <-- Constructor with 2 parameters
        if (id == null || id.isBlank()) { // <-- isBlank() only works from java 11 and above
            this.id = UUID.randomUUID().toString();
        } else {
            this.id = id;
        }

        this.name = name;
    }

    public Student(String name) { // <-- Another Constructor
        this(UUID.randomUUID().toString(), name); // <-- Calling first constructor
    }

    /* getter and setter methods(also known as accessor and mutator methods) */

    public String getId() {
        return id; // <-- Methods can access properties with and without this keyword.
    }

    public String getName() { // <-- Getter/Accessor method
        return name;
    }

    public void setName(String name) { // <-- Setter/Mutator method
        this.name = name;
    }
}
