package com.kurly.delivery.domain.user.service;

import com.kurly.delivery.domain.user.enumerable.ERole;
import com.kurly.delivery.domain.user.model.User;
import com.kurly.delivery.domain.user.repository.UserRepository;
import com.kurly.delivery.security.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProvider {
    private final UserRepository userRepository;

    public User getUser(){
        UserDetailsImpl userDetails =
                (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return User
                .builder()
                .id(userDetails.getId())
                .name(userDetails.getName())
                .email(userDetails.getEmail())
                .role(ERole.parse(userDetails.getAuthority()))
                .build();
    }
}
