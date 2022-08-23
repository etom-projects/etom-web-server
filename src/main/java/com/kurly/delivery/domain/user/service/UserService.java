package com.kurly.delivery.domain.user.service;

import com.kurly.delivery.domain.user.enumerable.ERole;
import com.kurly.delivery.domain.user.model.JobType;
import com.kurly.delivery.domain.user.model.User;
import com.kurly.delivery.domain.user.model.UserCar;
import com.kurly.delivery.domain.user.repository.JobTypeRepository;
import com.kurly.delivery.domain.user.repository.UserRepository;
import com.kurly.delivery.exception.CustomException;
import com.kurly.delivery.exception.ErrorCode;
import com.kurly.delivery.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final JobTypeRepository jobTypeRepository;
    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    private final PasswordEncoder passwordEncoder;
    @Transactional
    public Long signUp(User user){
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new CustomException(ErrorCode.DUPLICATED_EMAIL);
        }

        user.updateRole(ERole.ROLE_USER);

        user.updateHashPassword(hashPassword(user.getHashPassword()));

        return userRepository.save(user).getId();
    }

    @Transactional
    public String signIn(User user){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getHashPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);


        return jwt;
    }

    @Transactional
    public User updateUserJob(User user, Long jobTypeId) {
        User savedUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_ENTITY));

        JobType jobType = jobTypeRepository.findById(jobTypeId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOT_FOUND_ENTITY));

        savedUser.updateJobType(jobType);

        return userRepository.save(savedUser);
    }

    private String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
