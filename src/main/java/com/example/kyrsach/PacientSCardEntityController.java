package com.example.kyrsach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PacientSCardEntityController {
    @Autowired
    private  PatientSCardEntityInterface patientSCardEntityInterface;

    @GetMapping("/get/pacientscard")
    public Iterable<PatientSCardEntity> getPatientSCardEntity() {
        return patientSCardEntityInterface.findAll();
    }
    @PostMapping("/add/pacientscard")
    public ResponseEntity<PatientSCardEntity> createPatientSCardEntity(@RequestBody PatientSCardEntity patientScard) {
        patientSCardEntityInterface.save(patientScard);
        return new ResponseEntity<>(patientScard, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/pacientscard/{id}")
    public ResponseEntity<Integer> deletePatientSCardEntity(@PathVariable Integer id){
        patientSCardEntityInterface.deleteById(id);
        return new ResponseEntity<>(id,HttpStatus.ACCEPTED);
    }
    @GetMapping("/get/pacientscard/{id}")
    public ResponseEntity<PatientSCardEntity> getPatientSCardEntity(@PathVariable Integer id){
        PatientSCardEntity pacientscard=patientSCardEntityInterface.findPatientSCardEntityByidpatientScard(id);
        return new ResponseEntity<>(pacientscard,HttpStatus.ACCEPTED);
    }
    @PutMapping("/update/pacientscard/{id}")
    public  ResponseEntity<String> updatePatientSCardEntity(@PathVariable Long id,@RequestBody PatientSCardEntity patientsCard){
        if(patientSCardEntityInterface.existsById(id.intValue())) {
            PatientSCardEntity pacientsOrig = patientSCardEntityInterface.findPatientSCardEntityByidpatientScard(id.intValue());
            if (!pacientsOrig.equals(patientsCard)) {
                patientsCard.setIdpatientScard(id.intValue());
                patientSCardEntityInterface.save(patientsCard);
                return new ResponseEntity<>("updatet", HttpStatus.GONE);
            } else {
                return new ResponseEntity<>("not updatet", HttpStatus.LOCKED);
            }
        }else {
            return new ResponseEntity<>("not exist",HttpStatus.BAD_REQUEST);
        }

    }
}
