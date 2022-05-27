package com.aca.homework.week18.website.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", nullable = false, length = 20)
    private String title;

    @Column(name = "description", nullable = false, length = 50)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_POSTS_USER_ID_USERS_ID"), nullable = false)
    User user;

    @Column(name = "postCreationDate", nullable = false)
    private LocalDate postCreationDate;

    @Transient
    private List<Long> imageBlobIds;

    Post() {

    }

    public Post(String title, String description, User user, LocalDate postCreationDate) {
        this.title = title;
        this.description = description;
        this.user = user;
        imageBlobIds = Collections.emptyList();
        this.postCreationDate = postCreationDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setImageBlobIds(List<Long> imageBlobIds) {
        this.imageBlobIds = imageBlobIds;
    }

    public List<Long> getImageBlobIds() {
        return imageBlobIds;
    }

    public LocalDate getPostCreationDate() {
        return postCreationDate;
    }

    public void setPostCreationDate(LocalDate postCreationDate) {
        this.postCreationDate = postCreationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;

        Post post = (Post) o;

        return Objects.equals(id, post.id) && Objects.equals(title, post.title) && Objects.equals(description, post.description) && Objects.equals(user, post.user) && Objects.equals(imageBlobIds, post.imageBlobIds) && Objects.equals(postCreationDate, post.postCreationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, user, imageBlobIds, postCreationDate);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", postCreationDate=" + postCreationDate +
                ", imageBlobIds=" + imageBlobIds +
                '}';
    }
}