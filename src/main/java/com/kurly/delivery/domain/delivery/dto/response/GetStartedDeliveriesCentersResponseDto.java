package com.kurly.delivery.domain.delivery.dto.response;

import com.kurly.delivery.domain.delivery.dto.DeliveryMapCenterDto;
import com.kurly.delivery.domain.delivery.dto.DeliveryMapDto;
import com.kurly.delivery.domain.delivery.model.Delivery;
import com.kurly.delivery.domain.delivery.model.DeliveryCenterPoint;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GetStartedDeliveriesCentersResponseDto {
    private List<DeliveryMapCenterDto> deliveriesMap = new ArrayList<>();

    public GetStartedDeliveriesCentersResponseDto(List<DeliveryCenterPoint> deliveries) {
        if (deliveries != null && !deliveries.isEmpty()) {
            Integer priority = 1;
            for (DeliveryCenterPoint deliveryCenter :deliveries) {
                deliveriesMap.add(new DeliveryMapCenterDto(deliveryCenter, priority));
                priority += 1;
            }
        }
    }
}
