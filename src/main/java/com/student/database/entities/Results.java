package com.student.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Results {

    @Id
    @GeneratedValue
    private Integer id;

    private String subject;

    private String grade;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;



    
}
