package com.kurly.delivery.domain.delivery.repository;

import com.kurly.delivery.domain.delivery.enumerable.DeliveryStatus;
import com.kurly.delivery.domain.delivery.model.Delivery;
import com.kurly.delivery.domain.delivery.repository.custom.CustomDeliveryRepository;
import com.kurly.delivery.domain.user.model.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long>, CustomDeliveryRepository {

    @Query(value = "select delivery " +
            "from Delivery delivery " +
            "inner join Order productOrder " +
            "   on delivery.order = productOrder " +
            "inner join Address address " +
            "   on productOrder.address = address " +
            "where address.addressGroup.id = :groupId and delivery.deliveryStatus = 'WAIT' and delivery.type.id = :jobTypeId")
    List<Delivery> findAllByAddressGroupIdAndJobTypeId (@Param("groupId") Long id, @Param("jobTypeId") Long jobTypeId);
}
