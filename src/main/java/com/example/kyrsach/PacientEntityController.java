package com.example.kyrsach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PacientEntityController {
    @Autowired
    private  PacientEntityInterface pacientEntityInterface;

    @GetMapping("/get/pacient")
    public Iterable<PacientEntity> getPacientEntities() {
        return pacientEntityInterface.findAll();
    }
    @PostMapping("/add/pacient")
    public ResponseEntity<PacientEntity> createPacientEntity(@RequestBody PacientEntity patient) {
        pacientEntityInterface.save(patient);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/pacient/{id}")
    public ResponseEntity<Integer> deletePacientEntity(@PathVariable Integer id){
        pacientEntityInterface.deleteById(id);
        return new ResponseEntity<>(id,HttpStatus.ACCEPTED);
    }
    @GetMapping("/get/pacient/{id}")
    public ResponseEntity<PacientEntity> getPacientEntity(@PathVariable Integer id){
        PacientEntity pacient=pacientEntityInterface.findPacientEntityByIdpacient(id);
        return new ResponseEntity<>(pacient,HttpStatus.ACCEPTED);
    }

}
