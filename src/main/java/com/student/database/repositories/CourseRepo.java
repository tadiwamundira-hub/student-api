package com.student.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.database.entities.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

    List<Course> findByNameContaining(String name);
    
}
