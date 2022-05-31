package com.aca.classroom.week15.user.service.version5;

import com.aca.classroom.week15.user.service.version5.facade.UserMapper;
import com.aca.classroom.week15.user.service.version5.facade.UserMapperImpl;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@Configuration
public class Config {

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }

     /*
    @Bean
    public UserMapper userMapper2() {
        return new UserMapperImpl();
    }
     */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public String jwtSecretKey(@Value("${jwt.secret.key}") String secretKey) {
        return secretKey;
    }

    @Bean
    public JwtBuilder jwtBuilder(String secretKey) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, secretKey);
    }
    /*
    @Bean
    public JwtBuilder jwtBuilder(@Value("${jwt.secret.key }") String jwtSecretKey) {
        return Jwts.builder().signWith(SignatureAlgorithm.HS256, jwtSecretKey);
    }
     */

    @Bean
    public JwtParser jwtParser(String secretKey) {
        return Jwts.parser().setSigningKey(secretKey);
    }

    /*
     @Bean
    public JwtParser jwtParser(@Value("${jwt.secret.key }") String jwtSecretKey) {
        return Jwts.parser().setSigningKey(jwtSecretKey);
    }
     */
    @Bean
    public String stringBean() {
        return "MYPREFIX";
    }

}