package com.mapri.webbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/hello")
    private ResponseEntity hello() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
