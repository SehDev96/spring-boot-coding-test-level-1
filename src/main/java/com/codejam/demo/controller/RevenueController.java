package com.codejam.demo.controller;

import com.codejam.demo.model.Revenue;
import com.codejam.demo.service.RevenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "demo/revenue")
public class RevenueController {

    @Autowired
    private RevenueService revenueService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getRevenueById(@PathVariable Integer id) throws Exception{
        return new ResponseEntity<>(revenueService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> insertNewRevenue(@RequestBody Revenue revenue) throws Exception{
        return new ResponseEntity<>(revenueService.saveRevenue(revenue),HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/remove/{id}")
    public ResponseEntity<?> deleteRevenueById(@PathVariable Integer id) throws Exception{
        revenueService.deleteRevenue(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<?> updateRevenue(@RequestBody Revenue revenue) throws Exception{
        return new ResponseEntity<>(revenueService.updateRevenue(revenue),HttpStatus.OK);
    }

}
