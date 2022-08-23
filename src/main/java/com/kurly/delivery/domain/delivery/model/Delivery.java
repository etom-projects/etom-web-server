package com.kurly.delivery.domain.delivery.model;

import com.kurly.delivery.domain.common.enumerable.Status;
import com.kurly.delivery.domain.common.model.BaseTimeEntity;
import com.kurly.delivery.domain.delivery.enumerable.DeliveryRank;
import com.kurly.delivery.domain.delivery.enumerable.DeliveryStatus;
import com.kurly.delivery.domain.order.model.Order;
import com.kurly.delivery.domain.user.model.JobType;
import com.kurly.delivery.domain.user.model.User;
import com.kurly.delivery.domain.user.model.UserCar;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DELIVERIES")
public class Delivery extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_TYPE_ID")
    private JobType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DELIVERY_MAN_ID")
    private User deliveryMan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SELECTED_CAR_ID")
    private UserCar selectedCar;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "DELIVERY_STATUS")
    private DeliveryStatus deliveryStatus;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "DELIVERY_RANK")
    private DeliveryRank deliveryRank;

    @Column(name = "BOX_TYPE")
    private String boxType;

    @Column(name = "INVOICE_NUMBER")
    private String invoiceNumber;

    @Column(name = "DELIVERED_DATE")
    private LocalDate deliveredDate;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    public void select(User user) {
        this.deliveryStatus = DeliveryStatus.SELECTED;
        this.deliveryMan = user;
    }

    public void start(UserCar car) {
        this.deliveryStatus = DeliveryStatus.STARTED;
        this.selectedCar = car;
    }
}
