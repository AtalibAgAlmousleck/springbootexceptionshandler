package com.codinglevel.spring_relationship.student.repository;

import com.codinglevel.spring_relationship.student.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    List<Student> findByNameContaining(String name);
}
