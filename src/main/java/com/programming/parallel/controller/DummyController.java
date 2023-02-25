package com.programming.parallel.controller;

import com.programming.parallel.dto.*;
import com.programming.parallel.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @Autowired
    DummyService dummyService;

    @GetMapping(path = "/")
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/dummy")
    public ResponseEntity<Dummy> getDummy() {
        return ResponseEntity.ok(dummyService.getDummy());
    }

    @GetMapping(path = "/dummyMono")
    public ResponseEntity<Dummy> getDummyMono() {
        return ResponseEntity.ok(dummyService.getMonoDummy());
    }


}
