package com.aca.homework.week18.website.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "IMAGES")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "blob_id", nullable = false)
    private Long blobId;

    @ManyToOne
    @JoinColumn(name = "post_id", foreignKey = @ForeignKey(name = "IMAGES_POST_ID_POST_ID"), nullable = false)
    private Post post;

    public Image() {

    }

    public Image(Long blobId, Post post) {
        this.blobId = blobId;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBlobId() {
        return blobId;
    }

    public void setBlobId(Long blobId) {
        this.blobId = blobId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Image{");
        sb.append("id=").append(id);
        sb.append(", blobId=").append(blobId);
        sb.append(", post=").append(post);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image)) return false;

        Image image = (Image) o;

        return Objects.equals(id, image.id) && Objects.equals(blobId, image.blobId) && Objects.equals(post, image.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, blobId, post);
    }
}