package com.kurly.delivery.domain.user.dto.request;

import com.kurly.delivery.domain.user.model.User;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
public class UserSignInRequestDto {
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;

    public User toEntity(){
        return User.builder()
                .email(email)
                .hashPassword(password)
                .build();
    }
}
