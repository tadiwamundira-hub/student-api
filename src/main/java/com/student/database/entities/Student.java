package com.student.database.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private Integer id;
    
    private String name;

    private String surname;
    
    @Column(unique = true)
    private String email;

    private int age;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;


    @ManyToOne
    @JoinColumn(name = "hall_id")
    private HallResident hall;

    @OneToOne(mappedBy = "student")
    private Results results;
}