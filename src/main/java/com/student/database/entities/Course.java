package com.student.database.entities;

import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.List;

import jakarta.persistence.Column;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Course {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Integer cId;
    
    @Column(name = "course")
    private String name;

    private String description;
    
    @ManyToMany
    @JoinTable(
        name = "student_courses",
        joinColumns = {
            @JoinColumn(name="course_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name="student_id")
        }
    )
    private List<Student> students;

}
