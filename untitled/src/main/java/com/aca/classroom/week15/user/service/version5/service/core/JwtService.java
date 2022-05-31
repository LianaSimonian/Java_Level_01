package com.aca.classroom.week15.user.service.version5.service.core;

public interface JwtService {

    String createToken(String username);

    String getUsername(String token);
}
