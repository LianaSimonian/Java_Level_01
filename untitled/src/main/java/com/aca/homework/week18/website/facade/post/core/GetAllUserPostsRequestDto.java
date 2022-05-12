package com.aca.homework.week18.website.facade.post.core;

public final class GetAllUserPostsRequestDto {

    private final Long userId;

    public GetAllUserPostsRequestDto(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetAllUserPostsRequestDto)) return false;

        GetAllUserPostsRequestDto that = (GetAllUserPostsRequestDto) o;

        return userId != null ? userId.equals(that.userId) : that.userId == null;
    }

    @Override
    public int hashCode() {
        return userId != null ? userId.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GetAllUserPostsRequestDto{");
        sb.append("userId=").append(userId);
        sb.append('}');
        return sb.toString();
    }
}