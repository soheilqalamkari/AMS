package com.asm.managment.Controller;


import com.asm.managment.Model.Guarantee;
import com.asm.managment.Service.Interface.GuaranteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Guarantee")
public class GuaranteeController {

    @Autowired
    private GuaranteeService guaranteeService;

    @GetMapping(value = "/api/v1.0/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Guarantee>> showAll(){
        List<Guarantee> guaranteeList;
        guaranteeList = guaranteeService.findAllGuarantees();
        return new ResponseEntity<>(guaranteeList,HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1.0/find/{guaranteeId}")
    public ResponseEntity<Guarantee> findGuaranteeById(@PathVariable Long guaranteeId){
        return new ResponseEntity<>(guaranteeService.findGuaranteeById(guaranteeId),HttpStatus.OK);
    }

    @PostMapping(value = "/api/v1.0/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guarantee> saveGuarantee(@RequestBody Guarantee guarantee){
        guaranteeService.saveGuarantee(guarantee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/api/v1.0/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guarantee> updateGuarantee(@RequestBody Guarantee guarantee){
        guaranteeService.updateGuarantee(guarantee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/v1/delete/{guaranteeId}")
    public ResponseEntity<Guarantee> deleteGuarantee(@PathVariable Long guaranteeId){
        guaranteeService.deleteGuarantee(guaranteeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/v1/delete")
    public ResponseEntity<Guarantee> deleteAllGuarantees(){
        guaranteeService.deleteAllGuarantees();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
