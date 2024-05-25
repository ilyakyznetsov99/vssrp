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
    public Iterable<DoctorEntity> getDoctorEntities() {
        return doctorEntityInterface.findAll();
    }
    @PostMapping("/add/doctor")
    public ResponseEntity<DoctorEntity> createDoctorEntity(@RequestBody DoctorEntity cabinet) {
        doctorEntityInterface.save(cabinet);
        return new ResponseEntity<>(cabinet, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/doctor/{id}")
    public ResponseEntity<Integer> deleteDoctorEntity(@PathVariable Integer id){
        if(doctorEntityInterface.existsById(id)){
        doctorEntityInterface.deleteById(id);
        return new ResponseEntity<>(id,HttpStatus.ACCEPTED);
        }
        else return new ResponseEntity<>(id,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/get/doctor/{id}")
    public ResponseEntity<DoctorEntity> getDoctorEntity(@PathVariable Integer id){

        DoctorEntity doctor=doctorEntityInterface.findDoctorEntityByIddoctor(id);
        return new ResponseEntity<>(doctor,HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/doctor/{id}")
    public  ResponseEntity<String> updateDoctorEntity(@PathVariable Long id,@RequestBody DoctorEntity doctorCard){
        if(doctorEntityInterface.existsById(id.intValue())) {
            DoctorEntity doctorOrig = doctorEntityInterface.findDoctorEntityByIddoctor(id.intValue());
            if (!doctorOrig.equals(doctorCard)) {
                doctorCard.setIddoctor(id.intValue());
                doctorEntityInterface.save(doctorCard);
                return new ResponseEntity<>("updatet", HttpStatus.GONE);
            } else {
                return new ResponseEntity<>("not updatet", HttpStatus.LOCKED);
            }
        }else {
            return new ResponseEntity<>("not exist",HttpStatus.BAD_REQUEST);
        }

    }
}
