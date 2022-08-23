package com.kurly.delivery.domain.delivery.dto.response;

import com.kurly.delivery.domain.delivery.dto.DeliveryRankDto;
import com.kurly.delivery.domain.delivery.dto.SimpleDeliveryDto;
import com.kurly.delivery.domain.delivery.enumerable.DeliveryRank;
import com.kurly.delivery.domain.delivery.model.Delivery;
import com.kurly.delivery.domain.user.model.JobType;
import lombok.Getter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GetStartedDeliveriesResponseDto {
    private Integer totalDeliveryCount;
    private List<DeliveryRankDto> deliveryRanks = new ArrayList<>();
    private List<SimpleDeliveryDto> deliveries = new ArrayList<>();

    public GetStartedDeliveriesResponseDto(List<Delivery> deliveries) {
        this.totalDeliveryCount = deliveries.size();
        if (deliveries != null && !deliveries.isEmpty()) {
            this.deliveries = deliveries.stream().map(SimpleDeliveryDto::new)
                    .collect(Collectors.toList());
            this.deliveryRanks = deliveriesToRankDtoList(deliveries);
        }
    }

    private List<DeliveryRankDto> deliveriesToRankDtoList(List<Delivery> deliveries) {
        List<DeliveryRankDto> deliveryRanks = new ArrayList<>();
        List<Delivery> aRankDeliveries = deliveries.stream()
                .filter(delivery -> delivery.getDeliveryRank() == DeliveryRank.A)
                .collect(Collectors.toList());

        deliveryRanks.add(new DeliveryRankDto(DeliveryRank.A, aRankDeliveries.size()));

        List<Delivery> bRankDeliveries = deliveries.stream()
                .filter(delivery -> delivery.getDeliveryRank() == DeliveryRank.B)
                .collect(Collectors.toList());

        deliveryRanks.add(new DeliveryRankDto(DeliveryRank.B, bRankDeliveries.size()));

        List<Delivery> cRankDeliveries = deliveries.stream()
                .filter(delivery -> delivery.getDeliveryRank() == DeliveryRank.C)
                .collect(Collectors.toList());

        deliveryRanks.add(new DeliveryRankDto(DeliveryRank.C, cRankDeliveries.size()));

        return deliveryRanks;
    }
}
