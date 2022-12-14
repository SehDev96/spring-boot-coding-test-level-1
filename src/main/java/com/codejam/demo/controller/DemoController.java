package com.codejam.demo.controller;

import com.codejam.demo.model.IdolPersonalInfo;
import com.codejam.demo.model.Revenue;
import com.codejam.demo.service.IdolPersonalInfoService;
import com.codejam.demo.service.IdolPersonalInfoServiceImpl;
import com.codejam.demo.service.RevenueService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "demo")
public class DemoController {


    @GetMapping(path = "/unit-test")
    ResponseEntity<Integer> getUnitTestResult() throws Exception{
        return null;
    }

}
