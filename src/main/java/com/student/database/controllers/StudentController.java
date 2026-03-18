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

import com.student.database.entities.Student;
import com.student.database.repositories.StudentRepository;

@RestController
//@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository){
        this.repository = repository;
    }

    
    @PostMapping("/students")
    public Student post(
        @RequestBody Student student
    ){
        return repository.save(student);
    }

    
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    
    @GetMapping("/students/{id}")
    public Student getById(
        @PathVariable Integer id
    ){
        return repository.findById(id).orElse(new Student());
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> getByName(
        @PathVariable("student-name") String name
    ){
        return repository.findByNameContaining(name);
    }
    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(
        @PathVariable Integer id
    ){
        repository.deleteById(id);
    }
}