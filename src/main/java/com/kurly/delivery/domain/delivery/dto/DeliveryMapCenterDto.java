package com.kurly.delivery.domain.delivery.dto;

import com.kurly.delivery.domain.delivery.model.DeliveryCenterPoint;
import lombok.Getter;

@Getter
public class DeliveryMapCenterDto {
    private Integer priority;
    private Integer freshness;
    private String latitude;
    private String longitude;

    public DeliveryMapCenterDto(DeliveryCenterPoint centerPoint, Integer priority) {
        this.priority = priority;
        this.freshness = centerPoint.getFreshness();
        this.latitude = centerPoint.getLatitude();
        this.longitude = centerPoint.getLongitude();
    }
}
