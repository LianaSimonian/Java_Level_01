package com.aca.classroom.week15.user.service.version4.facade;

public class UserGraduationRequestDto {

    private final String username;

    public UserGraduationRequestDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}