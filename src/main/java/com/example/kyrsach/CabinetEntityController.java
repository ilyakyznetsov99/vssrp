package com.example.kyrsach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CabinetEntityController {
    @Autowired
    private  CabinetEntitiyInterface cabinetEntitiyInterface;

    @GetMapping("/get/cabinets")
    public Iterable<CabinetEntity> getCabinetEntities() {
        return cabinetEntitiyInterface.findAll();
    }
    @PostMapping("/add/cabinet")
    public ResponseEntity<CabinetEntity> createCabinetEntity(@RequestBody CabinetEntity cabinet) {
        // customer.setId(String.valueOf(customerId++));
        //customers.add(customer);
        cabinetEntitiyInterface.save(cabinet);
        return new ResponseEntity<>(cabinet, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/cabinet/{id}")
    public ResponseEntity<Integer> deleteCabinetEntity(@PathVariable Integer id){
        cabinetEntitiyInterface.deleteById(id);
        return new ResponseEntity<>(id,HttpStatus.ACCEPTED);
    }
    @GetMapping("/get/cabinet/{id}")
    public ResponseEntity<CabinetEntity> getCabinetEntity(@PathVariable Integer id){

        CabinetEntity cabinet=cabinetEntitiyInterface.findCabinetEntitiesByNumcab(id);

        return new ResponseEntity<>(cabinet,HttpStatus.ACCEPTED);
    }
    @PutMapping("/update/cabinet/{id}")
    public  ResponseEntity<String> updateCabinetEntity(@PathVariable Long id,@RequestBody CabinetEntity cabinet){
       if(cabinetEntitiyInterface.existsById(id.intValue())) {
           CabinetEntity cabinetorig = cabinetEntitiyInterface.findCabinetEntitiesByNumcab(id.intValue());
           if (!cabinetorig.equals(cabinet)) {
               cabinet.setNumcab(id.intValue());
               cabinetEntitiyInterface.save(cabinet);
               return new ResponseEntity<>("updatet", HttpStatus.GONE);
           } else {
               return new ResponseEntity<>("not updatet", HttpStatus.LOCKED);
           }
       }else {
           return new ResponseEntity<>("not exist",HttpStatus.BAD_REQUEST);
       }

    }
}