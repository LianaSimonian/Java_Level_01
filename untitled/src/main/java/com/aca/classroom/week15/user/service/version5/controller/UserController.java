package com.aca.classroom.week15.user.service.version5.controller;

import com.aca.classroom.week15.user.service.version5.facade.user.UserFacade;
import com.aca.classroom.week15.user.service.version5.service.core.JwtService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;;

@RestController
@RequestMapping(path = "users", consumes = "application/json", produces = "application/json")
public class UserController {

    private final UserFacade userFacade;
    private final JwtService jwtService;

    public UserController(UserFacade userFacade, JwtService jwtService) {
        this.userFacade = userFacade;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> logIn(@RequestBody UserLoginRequestDto dto) {
        String token = jwtService.createToken(dto.getUsername());
        UserLoginResponseDto body = new UserLoginResponseDto();
        body.setUsername(dto.getUsername());
        body.setToken(token);
        return ResponseEntity.ok(body);
    }

}
/*
import com.aca.classroom.week15.user.service.version5.facade.user.UserFacade;
import com.aca.classroom.week15.user.service.version5.service.JwtService;
import com.aca.homework.week10.template.PageRenderer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
/*
@RestController
@RequestMapping(
        path = "users",
        consumes = "application/json",
        produces = "application/json"
)
public class UserController {

    private UserFacade userFacade;
    private final JwtService jwtService;

    public UserController(UserFacade userFacade, JwtService jwtService) {
        this.userFacade = userFacade;
        this.jwtService = jwtService;
    }

    @PostMapping(path = "login")
    public ResponseEntity<UserLoginResponseDto>  logIn(@RequestBody  UserLoginRequestDto dto ){
        /*
        final String tocken =  Jwts.builder().signWith(SignatureAlgorithm.HS256,"hdjdhjdfs")
                .setIssuedAt(new Date())
                .claim("username",dto.getUsername())
                .compact();

         */
/*
        String tocken = jwtService.createToken(dto.getUsername());
        final UserLoginResponseDto body = new UserLoginResponseDto();
        body.setUsername(dto.getUsername());
        body.setToken(tocken);
        return  ResponseEntity.ok(body);
      //  Jwts parse = Jwts.parser().setSigningKey("hdjdhjdfs").parse(tocken);
       // final Claims body = (Claims) parse.getBody();
    }

}

 */
