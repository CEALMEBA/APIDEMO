package com.example.demo.Crontrollers;

import com.example.demo.Models.Admin;
import com.example.demo.Services.ServiceAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("Admin")
public class AdminCrontoller {

    @Autowired
    private ServiceAdmin service;

    @PostMapping
    public ResponseEntity createAdmin(@RequestBody Admin ad){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createAdmin(ad));
    }

    @PutMapping("{adminId}")
    public ResponseEntity updateAdmin(@PathVariable (name = "adminId", required = true) long adminId,
                                         @RequestBody Admin ad){
        service.updateAdmin(adminId,ad);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("{adminId}")
    public ResponseEntity deleteAdmin(@PathVariable(name = "adminId", required = true) long adminId){
        service.deleteAdmin(adminId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity findAdmin(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("{AdminId}")
    public ResponseEntity getOneAdmin(@PathVariable (name = "adminId", required = true) long adminId){
        return ResponseEntity.status(HttpStatus.OK).body(service.getOneAdmin(adminId));
    }
}
