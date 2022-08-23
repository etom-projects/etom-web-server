package com.kurly.delivery.domain.user.dto;

import com.kurly.delivery.domain.user.model.UserCar;
import lombok.Getter;

@Getter
public class CarDto {
    private Long userCarId;
    private String carModel;
    private String licensePlate;
    private String licensePlateColor;

    public CarDto(UserCar car) {
        this.userCarId = car.getId();
        this.carModel = car.getModel();
        this.licensePlate = car.getLicensePlate();
        this.licensePlateColor = car.getLicensePlateColor();
    }
}
