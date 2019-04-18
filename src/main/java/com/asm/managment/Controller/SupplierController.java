package com.asm.managment.Controller;

import com.asm.managment.Model.Supplier;
import com.asm.managment.Service.Interface.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping(value = "/Supplier/api/v1.0/find/{supplierId}")
    public ResponseEntity<Supplier> findById(@PathVariable Long supplierId){

        return new ResponseEntity<>(supplierService.findSupplierById(supplierId),HttpStatus.OK);
    }

    @PostMapping(value = "/Supplier/api/v1.0/save")
    public ResponseEntity<Supplier> save(@RequestBody Supplier supplier){

        supplierService.save(supplier);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/Supplier/api/v1.0/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Supplier>> getAll(){

        List<Supplier> supplierList;
        supplierList = supplierService.findSuppliers();
        return new ResponseEntity<>(supplierList,HttpStatus.OK);
    }

    @PutMapping(value = "/Supplier/api/v1.0/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Supplier> update(@RequestBody Supplier supplier){

        supplierService.updateSupplier(supplier);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/Supplier/api/v1.0/delete/{supplierId}")
    public ResponseEntity<Supplier> delete(@PathVariable Long supplierId){
        supplierService.deleteSupplier(supplierId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "Supplier/api/v1.0/delete")
    public ResponseEntity<Supplier> deleteAll(){
        supplierService.deleteAllSuppliers();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
