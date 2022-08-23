package com.kurly.delivery.domain.delivery.controller;

import com.kurly.delivery.domain.delivery.dto.request.SelectDeliveriesRequestDto;
import com.kurly.delivery.domain.delivery.dto.request.StartedDeliveriesRequestDto;
import com.kurly.delivery.domain.delivery.dto.response.GetJobDeliveriesResponseDto;
import com.kurly.delivery.domain.delivery.dto.response.GetStartedDeliveriesCentersResponseDto;
import com.kurly.delivery.domain.delivery.dto.response.GetStartedDeliveriesMapResponseDto;
import com.kurly.delivery.domain.delivery.dto.response.GetStartedDeliveriesResponseDto;
import com.kurly.delivery.domain.delivery.model.Delivery;
import com.kurly.delivery.domain.delivery.model.DeliveryCenterPoint;
import com.kurly.delivery.domain.delivery.service.DeliveryCenterPointService;
import com.kurly.delivery.domain.delivery.service.DeliveryJobService;
import com.kurly.delivery.domain.user.model.JobType;
import com.kurly.delivery.domain.user.model.User;
import com.kurly.delivery.domain.user.service.JobService;
import com.kurly.delivery.domain.user.service.UserProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/deliveries")
public class DeliveryController {
    private final UserProvider userProvider;
    private final JobService jobService;
    private final DeliveryJobService deliveryJobService;
    private final DeliveryCenterPointService deliveryCenterPointService;

    @GetMapping("/jobs")
    public ResponseEntity<List<GetJobDeliveriesResponseDto>> getJobDeliveries(@RequestParam Long addressGroupId) {
        List<GetJobDeliveriesResponseDto> responseDtoList = new ArrayList<>();
        List<JobType> jobTypes = jobService.getJobTypes();

        for (JobType jobType :jobTypes) {
            List<Delivery> deliveries = deliveryJobService.getTargetAddressDeliveries(addressGroupId, jobType);
            GetJobDeliveriesResponseDto responseDto = new GetJobDeliveriesResponseDto(jobType, deliveries);
            responseDtoList.add(responseDto);
        }

        return ResponseEntity.ok(responseDtoList);
    }

    @PatchMapping("/selected")
    public ResponseEntity<String> selectDeliveries(@RequestBody @Valid  SelectDeliveriesRequestDto requestDto) {
        User user = userProvider.getUser();
        deliveryJobService.selectDeliveries(requestDto.getDeliveryIds(), user);
        return ResponseEntity.ok("successfully deliveries select");
    }

    @PatchMapping("/started")
    public ResponseEntity<String> startDeliveries(@RequestBody @Valid StartedDeliveriesRequestDto requestDto) {
        User user = userProvider.getUser();
        deliveryJobService.startDeliveries(requestDto.getDeliveryIds(), requestDto.getCarId());
        return ResponseEntity.ok("successfully deliveries start");
    }

    @GetMapping("/started")
    public ResponseEntity<GetStartedDeliveriesResponseDto> getStartedDeliveries() {
        User user = userProvider.getUser();
        List<Delivery> startedDeliveries = deliveryJobService.getMyStartedDeliveries(user);
        return ResponseEntity.ok(new GetStartedDeliveriesResponseDto(startedDeliveries));
    }

    @GetMapping("/started/maps")
    public ResponseEntity<GetStartedDeliveriesMapResponseDto> getStartedDeliveriesMap() {
        User user = userProvider.getUser();
        List<Delivery> startedDeliveries = deliveryJobService.getMyStartedDeliveries(user);
        return ResponseEntity.ok(new GetStartedDeliveriesMapResponseDto(startedDeliveries));
    }

    @GetMapping("/started/maps/centers")
    public ResponseEntity<GetStartedDeliveriesCentersResponseDto> getStartedDeliveriesCenters(@RequestParam Long groupId) {
        List<DeliveryCenterPoint> startedDeliveries = deliveryCenterPointService.getCenterPointsOfAddressGroup(groupId);
        return ResponseEntity.ok(new GetStartedDeliveriesCentersResponseDto(startedDeliveries));
    }
}
