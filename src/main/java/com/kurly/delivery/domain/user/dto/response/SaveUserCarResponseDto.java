package com.kurly.delivery.domain.user.dto.response;

import com.kurly.delivery.domain.user.model.UserCar;
import lombok.Getter;

@Getter
public class SaveUserCarResponseDto {

    public SaveUserCarResponseDto(UserCar userCar) {
        userCar.getId();
    }
}
