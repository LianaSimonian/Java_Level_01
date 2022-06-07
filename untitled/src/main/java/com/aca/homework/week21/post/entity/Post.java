package com.aca.homework.week21.post.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_ID_SEQUENCE")
    @SequenceGenerator(name = "POST_ID_SEQUENCE")
    private Long id;

    @Column(name = "creationDate", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "creatorName", nullable = false, length = 15)
    private String createdBy;

    public Post() {

    }

    public Post(LocalDateTime creationDate, String content, String createdBy) {
        this.creationDate = creationDate;
        this.content = content;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(creationDate, post.creationDate) && Objects.equals(content, post.content) && Objects.equals(createdBy, post.createdBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationDate, content, createdBy);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", content='" + content + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}