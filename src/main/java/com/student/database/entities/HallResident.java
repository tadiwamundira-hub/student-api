package com.student.database.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HallResident {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(name = "hall_name")
    private String name;
    
    //private String description;

    @OneToMany(mappedBy = "hall")
    private List<Student> students;

}
