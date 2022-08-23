package com.kurly.delivery.domain.delivery.dto;

import com.kurly.delivery.domain.delivery.model.Delivery;
import lombok.Getter;

@Getter
public class SimpleDeliveryDto {
    private String invoiceNumber;
    private String state;
    private String zipCode;
    private String deliveryRank;

    public SimpleDeliveryDto(Delivery delivery) {
        this.invoiceNumber = delivery.getInvoiceNumber();
        this.state = delivery.getOrder().getAddress().getState();
        this.zipCode = delivery.getOrder().getAddress().getZipCode();
        this.deliveryRank = delivery.getDeliveryRank().name();
    }
}
