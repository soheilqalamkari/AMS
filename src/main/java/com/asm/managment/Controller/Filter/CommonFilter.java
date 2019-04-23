package com.asm.managment.Controller.Filter;

import com.asm.managment.Model.Factor;
import com.asm.managment.Model.Guarantee;
import com.asm.managment.Model.Supplier;
import com.asm.managment.Service.Interface.FactorService;
import com.asm.managment.Service.Interface.GuaranteeService;
import com.asm.managment.Service.Interface.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @Autowired
    private GuaranteeService guaranteeService;


    @GetMapping(value = "api/v1.0/factors")
    public ResponseEntity<List<Factor>> filterFactorByDate(@RequestBody Map<String, Object> filter) {

        List<Factor> factorList;
        Long date = (Long) filter.get("dateFrom");
        Date from = new Date(date);
        factorList = factorService.findFactorsByDate(from);
        return new ResponseEntity<>(factorList, HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1.0/suppliers",consumes = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<List<Supplier>> filterSupplierByNameAndPhone(@RequestBody Supplier supplier) {
        List<Supplier> supplierList = null;
        if (supplier.getPhone()==null&&supplier.getName()==null){
            supplierList = supplierService.findSuppliers();
            return new ResponseEntity<>(supplierList,HttpStatus.OK);
        }else {
            if (supplier.getName()!=null){
                supplierList.add(supplierService.findByName(supplier.getName()));
                return new ResponseEntity<>(supplierList,HttpStatus.OK);
            }else {
                if (supplier.getPhone()!=null){
                    supplierList.add(supplierService.findByPhone(supplier.getPhone()));
                    return new ResponseEntity<>(supplierList,HttpStatus.OK);
                }
                else
                    supplierList.add(supplierService.findByNameAndPhone(supplier.getName(),supplier.getPhone()));
                    return new ResponseEntity<>(supplierList,HttpStatus.OK);
            }
        }

    }

    @GetMapping(value = "/api/v1.0/guarantees",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Guarantee>>filterGuaranteeByNameAndDuring(@RequestBody Guarantee guarantee){
        List<Guarantee> guaranteeList;
        if (guarantee.getName()==null&&guarantee.getDuring()==null){
            guaranteeList = guaranteeService.findAllGuaranteesOrderByDuring();
            return new ResponseEntity<>(guaranteeList,HttpStatus.OK);
        }else {
            if (guarantee.getName()!=null){
                guaranteeList = guaranteeService.findAllByNameOrderByDuring(guarantee.getName());
                return new ResponseEntity<>(guaranteeList,HttpStatus.OK);
            }else {
                if (guarantee.getDuring() != null) {
                    guaranteeList = guaranteeService.findByDuring(guarantee.getDuring());
                    return new ResponseEntity<>(guaranteeList, HttpStatus.OK);
                } else
//                    guaranteeList = guaranteeService.findByNameAndDuring(guarantee.getName(), guarantee.getDuring());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
    }

}
