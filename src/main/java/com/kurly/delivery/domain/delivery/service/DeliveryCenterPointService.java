package com.kurly.delivery.domain.delivery.service;

import com.kurly.delivery.domain.delivery.model.DeliveryCenterPoint;
import com.kurly.delivery.domain.delivery.repository.DeliveryCenterPointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryCenterPointService {
    private final DeliveryCenterPointRepository deliveryCenterPointRepository;

    public List<DeliveryCenterPoint> getCenterPointsOfAddressGroup(Long groupId) {
        return deliveryCenterPointRepository.findAllByGroupId(groupId);
    }
}
