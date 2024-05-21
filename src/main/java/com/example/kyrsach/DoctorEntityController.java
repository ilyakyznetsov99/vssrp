package com.example.kyrsach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorEntityController {
    @Autowired
    private  DoctorEntityInterface doctorEntityInterface;

    @GetMapping("/get/doctors")
    public Iterable<DoctorEntity> getCabinetEntities() {
        return doctorEntityInterface.findAll();
    }
    @PostMapping("/add/doctor")
    public ResponseEntity<DoctorEntity> createCabinetEntity(@RequestBody DoctorEntity cabinet) {
        doctorEntityInterface.save(cabinet);
        return new ResponseEntity<>(cabinet, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/doctor/{id}")
    public ResponseEntity<Integer> deleteCabinetEntity(@PathVariable Integer id){
        doctorEntityInterface.deleteById(id);
        return new ResponseEntity<>(id,HttpStatus.ACCEPTED);
    }
    @GetMapping("/get/doctor/{id}")
    public ResponseEntity<DoctorEntity> getCabinetEntity(@PathVariable Integer id){

        DoctorEntity doctor=doctorEntityInterface.findDoctorEntityByIddoctor(id);
        return new ResponseEntity<>(doctor,HttpStatus.ACCEPTED);
    }

}
