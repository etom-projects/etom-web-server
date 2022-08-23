package com.kurly.delivery.domain.delivery.dto.response;

import com.kurly.delivery.domain.delivery.dto.DeliveryRankDto;
import com.kurly.delivery.domain.delivery.enumerable.DeliveryRank;
import com.kurly.delivery.domain.delivery.model.Delivery;
import com.kurly.delivery.domain.user.model.JobType;
import lombok.Getter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GetJobDeliveriesResponseDto {
    private LocalTime startTime;
    private LocalTime finishTime;
    private Integer totalDeliveryCount;
    private List<DeliveryRankDto> deliveryRanks = new ArrayList<>();
    private List<Long> deliveryIds = new ArrayList<>();

    public GetJobDeliveriesResponseDto(JobType jobType, List<Delivery> deliveries) {
        this.startTime = jobType.getStartTime();
        this.finishTime = jobType.getFinishTime();
        this.totalDeliveryCount = deliveries.size();
        if (deliveries != null && !deliveries.isEmpty()) {
            this.deliveryIds = deliveries.stream().map(delivery -> delivery.getId())
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
