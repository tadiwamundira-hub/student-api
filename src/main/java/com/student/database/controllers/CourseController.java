package com.student.database.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.student.database.entities.Course;
import com.student.database.repositories.CourseRepo;

@RestController
public class CourseController {
    public final CourseRepo repository;

    public CourseController(CourseRepo repository){
        this.repository = repository;
    }

    @PostMapping("/courses")
    public Course post(
        @RequestBody Course course
    ){
        return repository.save(course);
    }

    
    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return repository.findAll();
    }

    
    @GetMapping("/courses/{id}")
    public Course getById(
        @PathVariable Integer id
    ){
        return repository.findById(id).orElse(new Course());
    }

    @GetMapping("/courses/search/{course-name}")
    public List<Course> getByName(
        @PathVariable("course-name") String name
    ){
        return repository.findByNameContaining(name);
    }
    @DeleteMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCourse(
        @PathVariable Integer id
    ){
        repository.deleteById(id);
    }
}
