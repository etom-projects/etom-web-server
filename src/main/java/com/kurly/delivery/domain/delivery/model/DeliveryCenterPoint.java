package com.kurly.delivery.domain.delivery.model;

import com.kurly.delivery.domain.address.model.AddressGroup;
import com.kurly.delivery.domain.common.enumerable.Status;
import com.kurly.delivery.domain.common.model.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DELIVERY_CENTER_POINTS")
public class DeliveryCenterPoint extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private AddressGroup addressGroup;

    private String latitude;

    private String longitude;

    private Integer freshness;

    @Enumerated(value = EnumType.STRING)
    private Status status;
}
