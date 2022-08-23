package com.kurly.delivery.domain.delivery.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
public class StartedDeliveriesRequestDto {
    @NotNull
    private List<Long> deliveryIds;

    @NotNull
    private Long carId;
}
