package com.student.database.repositories;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.database.entities.Student;

public interface StudentRepository extends JpaRepository<Student , Integer> {

    List<Student> findByNameContaining(String p);
    
}
