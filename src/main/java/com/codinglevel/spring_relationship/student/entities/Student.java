package com.codinglevel.spring_relationship.student.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String name;
    private String email;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_course",
            joinColumns = {
                    @JoinColumn(
                            name = "student_id",
                            referencedColumnName = "studentId"
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "course_id",
                            referencedColumnName = "courseId"
                    )
            }
    )

    @JsonManagedReference
    private List<Course> courses;

//    public void addCourse(Course course) {
//        if (courses == null) {
//            courses = new ArrayList<>();
//        }
//        courses.add(course);
//    }
}
