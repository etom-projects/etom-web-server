package com.kurly.delivery.domain.delivery.dto;

import com.kurly.delivery.domain.delivery.enumerable.DeliveryRank;
import com.kurly.delivery.domain.user.enumerable.EJobType;
import lombok.Getter;

@Getter
public class DeliveryRankDto {
    private String rank;
    private String pay;
    private Integer deliveryCount;

    public DeliveryRankDto(DeliveryRank deliveryRank, Integer deliveryCount) {
        if (deliveryCount == null) {
            deliveryCount = 0;
        }

        switch(deliveryRank) {
            case A:
                this.rank = "A";
                this.pay = "5000";
                this.deliveryCount = deliveryCount;
                break;
            case B:
                this.rank = "B";
                this.pay = "3500";
                this.deliveryCount = deliveryCount;
                break;
            case C:
                this.rank = "C";
                this.pay = "3000";
                this.deliveryCount = deliveryCount;
                break;
            default:
                throw new IllegalArgumentException("잘못된 인수입니다");
        }
    }
}
