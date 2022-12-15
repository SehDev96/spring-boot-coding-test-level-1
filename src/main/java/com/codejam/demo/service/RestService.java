package com.codejam.demo.service;

import com.codejam.demo.interceptors.HttpRequestInterceptor;
import com.codejam.demo.model.TodoResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class RestService {

    private final RestTemplate restTemplate = new RestTemplate();

    public RestService() {
        restTemplate.setInterceptors(Collections.singletonList(new HttpRequestInterceptor()));
    }

    public ResponseEntity<?> getRequest(HttpHeaders headers, String url){
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        return new ResponseEntity<>(responseEntity.getBody(),responseEntity.getStatusCode());
    }

    public ResponseEntity<?> getRequest(String url) throws Exception{
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url,String.class);
        TodoResponse todoResponse = new ObjectMapper().readValue(responseEntity.getBody(),TodoResponse.class);
        return new ResponseEntity<>(todoResponse,responseEntity.getStatusCode());
    }


}
