package com.kurly.delivery.domain.user.service;

import com.kurly.delivery.domain.user.model.User;
import com.kurly.delivery.domain.user.model.UserCar;
import com.kurly.delivery.domain.user.repository.UserCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCarService {
    private final UserCarRepository userCarRepository;

    @Transactional
    public UserCar save(UserCar userCar){
        return userCarRepository.save(userCar);
    }

    @Transactional
    public List<UserCar> getMyCars(User user) {
        return userCarRepository.findAllByUserId(user.getId());
    }

    @Transactional
    public List<UserCar> getAll() {
        return userCarRepository.findAll();
    }
}
