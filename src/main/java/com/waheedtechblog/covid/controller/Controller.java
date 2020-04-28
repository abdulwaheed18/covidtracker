package com.waheedtechblog.covid.controller;

import com.waheedtechblog.covid.rest.RestService;
import com.waheedtechblog.covid.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private CovidService covidService;

    @GetMapping("/test")
    public ResponseEntity<String> testAPI() {
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/daywise")
    public ResponseEntity<String> getTimeWiseRecord(){
        return ResponseEntity.ok(covidService.getDayWiseRecord());
    }
}
