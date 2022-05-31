package com.aca.classroom.week15.user.service.version5.service.impl;

import com.aca.classroom.week15.user.service.version5.service.core.JwtService;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service
public class JwtServiceImpl implements JwtService {

    private final JwtBuilder jwtBuilder;
    private final JwtParser jwtParser;

    public JwtServiceImpl(JwtBuilder jwtBuilder, JwtParser jwtParser) {
        this.jwtBuilder = jwtBuilder;
        this.jwtParser = jwtParser;
    }

    @Override
    public String createToken(String username) {
        return jwtBuilder
                .claim("tokenId", UUID.randomUUID().toString())
                .claim("username", username).compact();
    }

    @Override
    public String getUsername(String token) {
        Claims body = (Claims) jwtParser.parse(token).getBody();
        return (String) body.get("username");
    }

    @PostConstruct
    public void test() {
        String token = createToken("test");
        System.out.println(getUsername(token) + "------------------------------------------");
    }
}
/*

import com.aca.classroom.week15.user.service.version5.service.JwtService;
import com.aca.homework.week19.job.platform.service.core.UserService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.servlet.http.PushBuilder;
import java.util.Date;

public class JwtServiceImpl implements JwtService {
    /*
     private final String jwtSecretKey;

     @Autowired
     private UserService userService;
     private Jwt

     public JwtServiceImpl(@Value("${jwt.secret.key }")String jwtSecretKey) {
         this.jwtSecretKey = jwtSecretKey;
     }

     */
/*
    private final JwtBuilder jwtBuilder;
    private final JwtParser jwtParser;

    public JwtServiceImpl(JwtBuilder jwtBuilder, JwtParser jwtParser) {
        this.jwtBuilder = jwtBuilder;
        this.jwtParser = jwtParser;
    }

    @Override
    public String createToken(String username) {
        return jwtBuilder
                .setIssuedAt(new Date())
                .claim("username", username)
                .compact();
    }

    @Override
    public String getUsername(String token) {
        // JwtParser jwtParser = jw
        //final Claims claims =
        Claims claims = (Claims) jwtParser.parse(token).getBody();
        return (String) claims.get("username");
    }

    @PostConstruct

    public void test() {
        System.out.println(createToken("test"));
        System.out.println(createToken("test"));
        System.out.println(createToken("test"));
        System.out.println(createToken("test"));
    }

}


 */