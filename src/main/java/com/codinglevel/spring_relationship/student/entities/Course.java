package com.codinglevel.spring_relationship.student.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String title;
    private double price;

    @ManyToMany(
            mappedBy = "courses",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JsonBackReference
    private List<Student> students;
}
