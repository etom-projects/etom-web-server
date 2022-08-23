package com.kurly.delivery.domain.delivery.dto;

import com.kurly.delivery.domain.delivery.model.Delivery;
import lombok.Getter;

@Getter
public class DeliveryMapDto {
    private String rank;
    private String latitude;
    private String longitude;

    public DeliveryMapDto(Delivery delivery) {
        this.rank = delivery.getDeliveryRank().name();
        this.latitude = delivery.getOrder().getAddress().getLatitude();
        this.longitude = delivery.getOrder().getAddress().getLongitude();
    }
}
