package com.kurly.delivery.domain.user.controller;

import com.kurly.delivery.domain.user.dto.request.SaveUserCarRequestDto;
import com.kurly.delivery.domain.user.dto.request.UpdateUserJobTypeRequestDto;
import com.kurly.delivery.domain.user.dto.response.GetJobTypeResponseDto;
import com.kurly.delivery.domain.user.dto.CarDto;
import com.kurly.delivery.domain.user.model.User;
import com.kurly.delivery.domain.user.model.UserCar;
import com.kurly.delivery.domain.user.service.JobService;
import com.kurly.delivery.domain.user.service.UserCarService;
import com.kurly.delivery.domain.user.service.UserProvider;
import com.kurly.delivery.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;
    private final UserService userService;
    private final UserCarService userCarService;
    private final UserProvider userProvider;

    @GetMapping("/types")
    public ResponseEntity<List<GetJobTypeResponseDto>> getJobTypes() {

        return ResponseEntity.ok(jobService.getJobTypes()
                .stream()
                .map(GetJobTypeResponseDto::new)
                .collect(Collectors.toList())
        );
    }

    @PostMapping("/users")
    public ResponseEntity<String> updateUserJob(@Valid
                                                @RequestBody
                                                UpdateUserJobTypeRequestDto updateUserJobTypeRequestDto) {
        User user = userProvider.getUser();
        userService.updateUserJob(user, updateUserJobTypeRequestDto.getJobTypeId());

        return ResponseEntity.ok("successfully user jobType update");
    }

    @PostMapping("/cars")
    public ResponseEntity<CarDto> saveUserCar(@Valid @RequestBody SaveUserCarRequestDto saveUserCarRequestDto){
        User user = userProvider.getUser();
        UserCar userCar = userCarService.save(saveUserCarRequestDto.toEntity(user));

        return ResponseEntity.ok(new CarDto(userCar));
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarDto>> getUserCars() {
        User user = userProvider.getUser();
        List<UserCar> cars = userCarService.getAll();

        return ResponseEntity.ok(cars.stream()
                .map(CarDto::new)
                .collect(Collectors.toList()));
    }
}
