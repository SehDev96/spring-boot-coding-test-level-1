package com.codejam.demo.controller;

import com.codejam.demo.service.RestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "demo")
public class DemoController {


    @GetMapping(path = "/unit-test")
    ResponseEntity<Integer> getUnitTestResult() throws Exception{
        return null;
    }

    @GetMapping(path = "/get-todo-data")
    ResponseEntity<?> getTodoData() throws Exception{
        String url = "https://jsonplaceholder.typicode.com/todos/1";
        RestService restService = new RestService();
        return restService.getRequest(url);
    }

}
