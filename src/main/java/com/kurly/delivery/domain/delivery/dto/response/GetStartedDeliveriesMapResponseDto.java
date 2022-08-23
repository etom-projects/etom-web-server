package com.kurly.delivery.domain.delivery.dto.response;

import com.kurly.delivery.domain.delivery.dto.DeliveryMapDto;
import com.kurly.delivery.domain.delivery.dto.DeliveryRankDto;
import com.kurly.delivery.domain.delivery.dto.SimpleDeliveryDto;
import com.kurly.delivery.domain.delivery.enumerable.DeliveryRank;
import com.kurly.delivery.domain.delivery.model.Delivery;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GetStartedDeliveriesMapResponseDto {
    private List<DeliveryMapDto> deliveriesMap = new ArrayList<>();

    public GetStartedDeliveriesMapResponseDto(List<Delivery> deliveries) {
        if (deliveries != null && !deliveries.isEmpty()) {
            this.deliveriesMap = deliveries.stream().map(DeliveryMapDto::new)
                    .collect(Collectors.toList());
        }
    }
}
