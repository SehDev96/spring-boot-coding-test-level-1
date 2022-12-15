package com.codejam.demo.controller;

import com.codejam.demo.model.Schedule;
import com.codejam.demo.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "demo/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getScheduleById(@PathVariable Integer id) throws Exception {
        // todo exceptions
        return new ResponseEntity<>(scheduleService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> insertNewSchedule(@RequestBody Schedule schedule) throws Exception {
        return new ResponseEntity<>(scheduleService.saveSchedule(schedule), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/remove/{id}")
    public ResponseEntity<?> deleteScheduleById(@PathVariable Integer id) throws Exception {
        scheduleService.deleteSchedule(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<?> updateSchedule(@RequestBody Schedule schedule) throws Exception {
        return new ResponseEntity<>(scheduleService.updateSchedule(schedule), HttpStatus.OK);
    }

}
