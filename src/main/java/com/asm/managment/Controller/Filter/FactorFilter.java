package com.asm.managment.Controller.Filter;

import com.asm.managment.Model.Factor;
import com.asm.managment.Service.Interface.FactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "Filter")
public class FactorFilter {

    @Autowired
    private FactorService factorService;


    @GetMapping(value = "api/v1.0/factors")
    public ResponseEntity<List<Factor>> filterByDate(@RequestBody Map<String,Object> filter){

        List<Factor> factorList = new ArrayList<>();
        Long date = (Long) filter.get("dateFrom");
        Date from = new Date(date);
        factorList = factorService.findFactorsByDate(from);
        return new ResponseEntity<>(factorList,HttpStatus.OK);
    }
}
