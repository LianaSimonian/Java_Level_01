package com.aca.homework.week21.post.dto;

import io.jsonwebtoken.lang.Assert;

import java.util.List;
import java.util.Objects;

public final class DeletePostResponseDto {

    private Long id;
    private boolean isSucceeded;

    private List<String> errors;

    public DeletePostResponseDto() {

    }

    public DeletePostResponseDto(Long id, List<String> errors) {
        Assert.notNull(id, "the id cannot be null");
        Assert.notNull(errors, "the errors list cannot be null");
        this.errors = errors;
        isSucceeded = false;
        this.id = id;
    }

    public DeletePostResponseDto(Long id, boolean isSucceeded) {
        Assert.notNull(id, "the id param cannot be null");
        Assert.notNull(isSucceeded, "the isSucceeded param cannot be null");
        this.id = id;
        this.isSucceeded = isSucceeded;
    }

    public Long getId() {
        return id;
    }

    public boolean isSucceeded() {
        return isSucceeded;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeletePostResponseDto that = (DeletePostResponseDto) o;
        return isSucceeded == that.isSucceeded && Objects.equals(id, that.id) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isSucceeded, errors);
    }

    @Override
    public String toString() {
        return "DeletePostResponseDto{" +
                "id=" + id +
                ", isSucceeded=" + isSucceeded +
                ", errors=" + errors +
                '}';
    }
}