package com.student.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.database.entities.HallResident;

public interface HallRepository extends JpaRepository<HallResident, Integer>{

    List<HallResident> findByNameContaining(String name);
    
}
