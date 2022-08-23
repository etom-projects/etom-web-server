package com.kurly.delivery.domain.delivery.repository.custom;

import com.kurly.delivery.domain.delivery.model.Delivery;
import com.kurly.delivery.domain.user.model.User;

import java.util.List;

public interface CustomDeliveryRepository {
    List<Delivery> findStartedDeliveries(User user);
}
