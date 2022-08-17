package com.codinglevel.spring_relationship.student.repository;

import com.codinglevel.spring_relationship.student.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByPriceLessThan(double price);
}
