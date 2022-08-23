package com.kurly.delivery.domain.delivery.repository;

import com.kurly.delivery.domain.delivery.model.DeliveryCenterPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeliveryCenterPointRepository extends JpaRepository<DeliveryCenterPoint, Long> {
    @Query(value = "select deliveryCenter " +
            "from DeliveryCenterPoint deliveryCenter " +
            "where deliveryCenter.addressGroup.id = :groupId " +
            "order by deliveryCenter.freshness desc ")
    List<DeliveryCenterPoint> findAllByGroupId(@Param("groupId") Long groupId);
}
