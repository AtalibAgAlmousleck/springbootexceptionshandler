package com.codinglevel.spring_relationship.student.controller;

import com.codinglevel.spring_relationship.student.entities.Course;
import com.codinglevel.spring_relationship.student.entities.Student;
import com.codinglevel.spring_relationship.student.repository.CourseRepository;
import com.codinglevel.spring_relationship.student.repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentCourseController {

    private final StudentRepo studentRepo;
    private final CourseRepository courseRepository;

    @PostMapping("/save")
    public Student saveStudentWithCourse(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    @GetMapping("/all")
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable("studentId") Long studentId) {
        return studentRepo.findById(studentId).orElse(null);
    }

    @GetMapping("search/{price}")
    public List<Course> findCourse(@PathVariable double price) {
        return courseRepository.findByPriceLessThan(price);
    }
}
