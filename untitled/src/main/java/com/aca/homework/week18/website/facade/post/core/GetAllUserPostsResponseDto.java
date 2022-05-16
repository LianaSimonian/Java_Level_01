package com.aca.homework.week18.website.facade.post.core;

import com.aca.homework.week18.website.facade.user.core.UserSignUpResponseDto;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public final class GetAllUserPostsResponseDto {

    private UserSignUpResponseDto userDto;
    private List<PostCreationResponseDto> postsDto;

    private List<String> errors;

    public GetAllUserPostsResponseDto(List<String> errors) {
        this.errors = errors;
    }

    public GetAllUserPostsResponseDto(UserSignUpResponseDto userDto, List<PostCreationResponseDto> postsDto) {
        Assert.notNull(userDto, "the userDto should not be null");
        Assert.notNull(postsDto, "the postDto should not be null");
        this.userDto = userDto;
        this.postsDto = postsDto;
    }

    public UserSignUpResponseDto getUserDto() {
        return userDto;
    }

    public List<PostCreationResponseDto> getPostsDto() {
        return postsDto;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GetAllUserPostsResponseDto)) return false;

        GetAllUserPostsResponseDto that = (GetAllUserPostsResponseDto) o;

        return Objects.equals(userDto, that.userDto) && Objects.equals(postsDto, that.postsDto) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userDto, postsDto, errors);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("GetAllUserPostsResponseDto{");
        sb.append("userDto=").append(userDto);
        sb.append(", postsDto=").append(postsDto);
        sb.append(", errors=").append(errors);
        sb.append('}');
        return sb.toString();
    }
}