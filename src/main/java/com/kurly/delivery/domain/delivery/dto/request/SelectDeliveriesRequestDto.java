package com.kurly.delivery.domain.delivery.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
public class SelectDeliveriesRequestDto {
    @NotNull
    List<Long> deliveryIds;
}
