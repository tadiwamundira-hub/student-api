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

import com.student.database.entities.HallResident;
import com.student.database.repositories.HallRepository;

@RestController
public class HallController {

    public final HallRepository repository;
        public HallController(HallRepository repository){
        this.repository = repository;
    }

    @PostMapping("/hall-resident")
    public HallResident post(
        @RequestBody HallResident dorm
    ){
        return repository.save(dorm);
    }

    
    @GetMapping("/hall-resident")
    public List<HallResident> getAllHalls(){
        return repository.findAll();
    }

    
    @GetMapping("/hall-resident/{id}")
    public HallResident getById(
        @PathVariable Integer id
    ){
        return repository.findById(id).orElse(new HallResident());
    }

    @GetMapping("/hall-resident/search/{hall-name}")
    public List<HallResident> getByName(
        @PathVariable("hall-name") String name
    ){
        return repository.findByNameContaining(name);
    }
    @DeleteMapping("/hall-resident/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteHall(
        @PathVariable Integer id
    ){
        repository.deleteById(id);
    }
}
