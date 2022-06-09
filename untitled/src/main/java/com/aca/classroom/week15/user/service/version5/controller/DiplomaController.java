package com.aca.classroom.week15.user.service.version5.controller;


import com.aca.classroom.week15.user.service.version5.service.core.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/diplomas", consumes = "application/json", produces = "application/json")
public class DiplomaController {

    private JwtService jwtService;

    public DiplomaController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping
    public ResponseEntity<String> createDiploma(@RequestBody DiplomaCreateDto dto, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        String username = jwtService.getUsername(token);
        return ResponseEntity.ok("You are " + username);
    }

    @GetMapping
    public ResponseEntity<String> getOk(){
        return ResponseEntity.ok("Ok");
    }

}
/*
import com.aca.classroom.week15.user.service.version5.service.JwtService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "diplomas",
        consumes = "application/json",
        produces = "application/json")
public class DiplomaController {

    private final JwtService jwtService;

    public DiplomaController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    /*
        @PostMapping
        public String create(@RequestBody DiplomaCreateSto dt, HttpServletRequest request) {
            return "test";
           // return request.getHeader("myId");
        }


    @PostMapping
    public ResponseEntity<String> create(@RequestBody DiplomaCreateSto dt, HttpServletRequest request) {
        final String token = request.getHeader("Authorization");
        final String username = jwtService.getUsername(token);
        return ResponseEntity.ok(request.getHeader("myId"));
        // return request.getHeader("myId");
    }
}


 */