package com.asm.managment.Controller;

import com.asm.managment.Model.Factor;
import com.asm.managment.Service.Interface.FactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FactorController {

    @Autowired
    private FactorService factorService;

    @GetMapping(value = "/Factor/api/v1.0/all",produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Factor>> showAll(){
        List<Factor> factorList;
        factorList = factorService.findFactors();
        return new ResponseEntity<>(factorList, HttpStatus.OK);
    }

    @GetMapping(value = "/Factor/api/v1.0/find/{factorId}")
    public ResponseEntity<Factor> findById(@PathVariable Long factorId){
        return new ResponseEntity<>(factorService.findFactorById(factorId),HttpStatus.OK);
    }

    @PostMapping(value = "/Factor/api/v1.0/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Factor> saveFactor(@RequestBody Factor factor){
        factorService.save(factor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/Factor/api/v1.0/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Factor> updateFactor(@RequestBody Factor factor){
        factorService.updateFactor(factor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/Factor/api/v1.0/delete/{factorId}")
    public ResponseEntity<Factor> deleteFactor(@PathVariable Long factorId){
        factorService.deleteFactor(factorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/Factor/api/v1.0/delete")
    public ResponseEntity<Factor> deleteAll(){
        factorService.deleteAllFactors();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
