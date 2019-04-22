package com.asm.managment.Controller.Filter;

import com.asm.managment.Model.Factor;
import com.asm.managment.Model.Supplier;
import com.asm.managment.Service.Interface.FactorService;
import com.asm.managment.Service.Interface.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "Filter")
public class CommonFilter {

    @Autowired
    private FactorService factorService;

    @Autowired
    private SupplierService supplierService;


    @GetMapping(value = "api/v1.0/factors")
    public ResponseEntity<List<Factor>> filterFactorByDate(@RequestBody Map<String, Object> filter) {

        List<Factor> factorList = new ArrayList<>();
        Long date = (Long) filter.get("dateFrom");
        Date from = new Date(date);
        factorList = factorService.findFactorsByDate(from);
        return new ResponseEntity<>(factorList, HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1.0/suppliers")
    public ResponseEntity<Supplier> filterSupplierByNameAndPhone(@RequestBody Supplier supplier) {


        if (supplier.getPhone()==null&&supplier.getName()==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            if (supplier.getName()!=null){
                return new ResponseEntity<>(supplierService.findByName(supplier.getName()),HttpStatus.OK);
            }else {
                if (supplier.getPhone()!=null){
                    return new ResponseEntity<>(supplierService.findByPhone(supplier.getPhone()),HttpStatus.OK);
                }else return new ResponseEntity<>(supplierService.findByNameAndPhone(supplier.getName(),supplier.getPhone()),HttpStatus.OK);
            }
        }
//        if (supplier.getName() != null) {
//            if (supplier.getPhone() != null) {
//                return new ResponseEntity<>(supplierService.findByNameAndPhone(supplier.getName(), supplier.getPhone()),HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(supplierService.findByName(supplier.getName()), HttpStatus.OK);
//            }
//
//        }else  {
//            return new ResponseEntity<>(supplierService.findByPhone(supplier.getPhone()), HttpStatus.OK);
//        }
//
//        //return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}

//
//        if (supplier.getName() != null) {
//            if (supplier.getPhone() != null) {
//                return new ResponseEntity<>(supplierService.findByNameAndPhone(supplier.getName(), supplier.getPhone()), HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(supplierService.findByName(supplier.getName()), HttpStatus.OK);
//            }
//        }
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }