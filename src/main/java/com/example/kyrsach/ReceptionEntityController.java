package com.example.kyrsach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReceptionEntityController {
    @Autowired
    private  ReceptionEntityInterface receptionEntityInterface;

    @GetMapping("/get/receptions")
    public Iterable<ReceptionEntity> getReceptionEntity() {
        return receptionEntityInterface.findAll();
    }
    @PostMapping("/add/reception")
    public ResponseEntity<ReceptionEntity> createReceptionEntity(@RequestBody ReceptionEntity reception) {
        receptionEntityInterface.save(reception);
        return new ResponseEntity<>(reception, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/reception/{id}")
    public ResponseEntity<Integer> deleteReceptionEntity(@PathVariable Integer id){
        receptionEntityInterface.deleteById(id);
        return new ResponseEntity<>(id,HttpStatus.ACCEPTED);
    }
    @GetMapping("/get/reception/{id}")
    public ResponseEntity<ReceptionEntity> getReceptionEntity(@PathVariable Integer id){

        ReceptionEntity reception=receptionEntityInterface.findReceptionEntityByIdreception(id);

        return new ResponseEntity<>(reception,HttpStatus.ACCEPTED);
    }
    @PutMapping("/update/reception/{id}")
    public  ResponseEntity<String> updateReceptionEntity(@PathVariable Long id,@RequestBody ReceptionEntity reception){
        if(receptionEntityInterface.existsById(id.intValue())) {
            ReceptionEntity receptionOrig = receptionEntityInterface.findReceptionEntityByIdreception(id.intValue());
            if (!receptionOrig.equals(reception)) {
                reception.setIdreception(id.intValue());
                receptionEntityInterface.save(reception);
                return new ResponseEntity<>("updatet", HttpStatus.GONE);
            } else {
                return new ResponseEntity<>("not updatet", HttpStatus.LOCKED);
            }
        }else {
            return new ResponseEntity<>("not exist",HttpStatus.BAD_REQUEST);
        }

    }
}
