package com.aca.classroom.week15.user.service.version5.controller;

public class UserLoginResponseDto {

    private String username;
    private String token;

    UserLoginResponseDto() {

    }

    public UserLoginResponseDto(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserLoginResponseDto{" +
                "username='" + username + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserLoginResponseDto)) return false;

        UserLoginResponseDto that = (UserLoginResponseDto) o;

        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        return token != null ? token.equals(that.token) : that.token == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }
}
