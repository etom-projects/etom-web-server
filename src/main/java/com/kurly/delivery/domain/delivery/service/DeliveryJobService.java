package com.kurly.delivery.domain.delivery.service;

import com.kurly.delivery.domain.delivery.enumerable.DeliveryStatus;
import com.kurly.delivery.domain.delivery.model.Delivery;
import com.kurly.delivery.domain.delivery.repository.DeliveryRepository;
import com.kurly.delivery.domain.user.model.JobType;
import com.kurly.delivery.domain.user.model.User;
import com.kurly.delivery.domain.user.model.UserCar;
import com.kurly.delivery.domain.user.repository.UserCarRepository;
import com.kurly.delivery.exception.CustomException;
import com.kurly.delivery.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryJobService {
    private final DeliveryRepository deliveryRepository;
    private final UserCarRepository userCarRepository;

    @Transactional(readOnly = true)
    public List<Delivery> getTargetAddressDeliveries(Long addressGroupId, JobType jobType) {
        return deliveryRepository.findAllByAddressGroupIdAndJobTypeId(addressGroupId, jobType.getId());
    }

    @Transactional
    public List<Delivery> selectDeliveries(List<Long> deliveryIds, User user) {
        List<Delivery> savedDeliveries = deliveryRepository.findAllById(deliveryIds);

        savedDeliveries.forEach(delivery -> delivery.select(user));

        return deliveryRepository.saveAll(savedDeliveries);
    }

    @Transactional
    public List<Delivery> startDeliveries(List<Long> deliveryIds, Long carId) {
        UserCar userCar = userCarRepository.findById(carId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_ENTITY));

        List<Delivery> savedDeliveries = deliveryRepository.findAllById(deliveryIds);

        savedDeliveries.forEach(delivery -> delivery.start(userCar));


        return deliveryRepository.saveAll(savedDeliveries);
    }

    @Transactional
    public List<Delivery> getMyStartedDeliveries(User user) {
        return deliveryRepository.findStartedDeliveries(user);
    }
}
