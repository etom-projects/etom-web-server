package com.kurly.delivery.domain.user.dto.request;

import com.kurly.delivery.domain.common.enumerable.Status;
import com.kurly.delivery.domain.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class UserSignUpRequestDto {
    @Email(message = "제대로된 이메일 형식을 입력해주세요")
    @NotEmpty
    @NotNull
    private String email;

    @Length(min = 8, max = 50, message = "비밀번호 길이를 확인해 주세요")
    private String password;

    @Length(min = 2, max = 15)
    private String name;

    @NotNull
    private String phoneNumber;


    public User toEntity(){
        return User.builder()
                .email(this.email)
                .hashPassword(this.password)
                .name(this.name)
                .phoneNumber(this.phoneNumber)
                .status(Status.ACTIVE)
                .build();
    }
}
