package com.codejam.demo.controller;

import com.codejam.demo.model.IdolPersonalInfo;
import com.codejam.demo.service.IdolPersonalInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "demo/personal-info")
public class IdolPersonalInfoController {

    @Autowired
    private IdolPersonalInfoService idolPersonalInfoService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getIdolPersonalInfoById(@PathVariable Integer id){
        // todo exceptions
        return new ResponseEntity<>(idolPersonalInfoService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> insertNewPersonalInfo(@RequestBody IdolPersonalInfo idolPersonalInfo){
        return new ResponseEntity<>(idolPersonalInfoService.saveIdolPersonalInfo(idolPersonalInfo),HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/remove/{id}")
    public ResponseEntity<?> deletePersonalInfoById(@PathVariable Integer id){
        idolPersonalInfoService.deleteIdolPersonalInfo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<?> updatePersonalInfo(@RequestBody IdolPersonalInfo idolPersonalInfo){
        return new ResponseEntity<>(idolPersonalInfoService.updateIdolPersonalInfo(idolPersonalInfo),HttpStatus.OK);
    }

}
