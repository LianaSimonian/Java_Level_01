package com.aca.homework.week21.post.dto;

import org.springframework.util.Assert;

import java.util.Objects;

public final class CatFactDto {

    private String fact;
    private Long length;

    public CatFactDto() {

    }

    public CatFactDto(String fact, Long length) {
        Assert.notNull(fact, "the fact cannot be null");
        Assert.notNull(length, "the length cannot be null");
        this.fact = fact;
        this.length = length;
    }

    public String getFact() {
        return fact;
    }

    public Long getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CatFactDto)) return false;

        CatFactDto factDto = (CatFactDto) o;

        return Objects.equals(fact, factDto.fact) && Objects.equals(length, factDto.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fact, length);
    }

    @Override
    public String toString() {
        return "FactDto{" +
                "fact='" + fact + '\'' +
                ", length='" + length + '\'' +
                '}';
    }
}
