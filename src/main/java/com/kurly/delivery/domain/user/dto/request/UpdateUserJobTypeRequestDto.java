package com.kurly.delivery.domain.user.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class UpdateUserJobTypeRequestDto {
    @NotNull
    private Long jobTypeId;
}
