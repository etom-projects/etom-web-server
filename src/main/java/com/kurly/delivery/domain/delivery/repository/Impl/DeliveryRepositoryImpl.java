package com.kurly.delivery.domain.delivery.repository.Impl;

import com.kurly.delivery.domain.delivery.enumerable.DeliveryStatus;
import com.kurly.delivery.domain.delivery.model.Delivery;
import com.kurly.delivery.domain.delivery.model.QDelivery;
import com.kurly.delivery.domain.delivery.repository.custom.CustomDeliveryRepository;
import com.kurly.delivery.domain.order.model.QOrder;
import com.kurly.delivery.domain.user.model.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DeliveryRepositoryImpl implements CustomDeliveryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Delivery> findStartedDeliveries(User user) {
        QDelivery delivery = QDelivery.delivery;
        QOrder order = QOrder.order;

        return queryFactory.selectFrom(delivery)
                .innerJoin(delivery.order, order)
                .fetchJoin()
                .innerJoin(order.address)
                .fetchJoin()
                .where(delivery.deliveryMan.id.eq(user.getId())
                        .and(delivery.deliveryStatus.eq(DeliveryStatus.STARTED))
                ).fetch();
    }
}
