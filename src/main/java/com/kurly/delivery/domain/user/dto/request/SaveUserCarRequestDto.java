package com.kurly.delivery.domain.user.dto.request;

import com.kurly.delivery.domain.common.enumerable.Status;
import com.kurly.delivery.domain.user.model.User;
import com.kurly.delivery.domain.user.model.UserCar;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class SaveUserCarRequestDto {
    @NotEmpty
    private String carModel;
    @NotEmpty
    private String carLicensePlate;
    @NotEmpty
    private String carLicensePlateColor;

    public UserCar toEntity(User user) {
        return UserCar
                .builder()
                .licensePlate(this.carLicensePlate)
                .licensePlateColor(this.carLicensePlateColor)
                .model(this.carModel)
                .user(user)
                .status(Status.ACTIVE)
                .build();
    }
}
