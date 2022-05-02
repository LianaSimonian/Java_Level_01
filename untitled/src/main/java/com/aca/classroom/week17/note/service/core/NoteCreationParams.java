package com.aca.classroom.week17.note.service.core;

import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Objects;

public final class NoteCreationParams {

    private final String text;
    private final Long userId;
    private final LocalDate creationDate;

    public NoteCreationParams(String text, Long userId, LocalDate creationDate) {
        Assert.hasText(text, "The text should not be null or empty");
        Assert.notNull(creationDate, "The creationDate should not be null");
        Assert.notNull(userId, "The user id should not be null");
        this.text = text;
        this.userId = userId;
        this.creationDate = creationDate;
    }

    public String getText() {
        return text;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        return "NoteCreationParams{" +
                "text='" + text + '\'' +
                ", userId=" + userId +
                ", creationDate=" + creationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NoteCreationParams)) return false;

        NoteCreationParams that = (NoteCreationParams) o;

        return Objects.equals(text, that.text) && Objects.equals(userId, that.userId) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, userId, creationDate);
    }
}