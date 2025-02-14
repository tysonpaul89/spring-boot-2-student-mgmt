package com.student.management;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students") // <-- Common path /students for all the APIs in the class
public class StudentController {

    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.addAll(List.of(
                new Student("Jack"),
                new Student("Jill")));
    }

    @GetMapping // <-- Can also use @RequestMapping
    Iterable<Student> getAllStudents() { // <-- Using Iterable<T> so that f/w will auto convert it to a JSON list
        // Spring Boot, via the Jackson dependencies included in Spring Web, performs
        // the marshalling and unmarshalling of objects to JSON or other formats
        // automatically.
        return students;
    }

    @GetMapping("/{id}")
    Optional<Student> getStudentById(@PathVariable String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return Optional.of(s);
            }
        }

        return Optional.empty();
    }

    @PostMapping
    ResponseEntity<Student> createStudent(@RequestBody Student student) { // <-- Spring Boot's automatic marshalling will convert
                                                          // incoming JSON to Student object
        students.add(student);
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }

    /**
     * Updates the student if already exists, else creates it
     */
    @PutMapping("/{id}")
    ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student student) {
        int itemIndex = -1;

        for (Student s : students) {
            if (s.getId().equals(id)) {
                itemIndex = students.indexOf(s);
                students.set(itemIndex, student);
            }
        }

        if (itemIndex == -1) {
            return createStudent(student); // <-- ResponseEntity is not needed since method is already returning it
        } else {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    void deleteStudent(@PathVariable String id) {
        students.removeIf(s -> s.getId().equals(id));
    }
}
