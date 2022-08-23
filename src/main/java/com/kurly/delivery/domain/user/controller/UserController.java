package com.kurly.delivery.domain.user.controller;

import com.kurly.delivery.domain.user.dto.request.UserSignInRequestDto;
import com.kurly.delivery.domain.user.dto.request.UserSignUpRequestDto;
import com.kurly.delivery.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody @Valid UserSignUpRequestDto singUpRequestDto){
        userService.signUp(singUpRequestDto.toEntity());
        return ResponseEntity.ok("User signUp successfully!");
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody @Valid UserSignInRequestDto signInRequestDto) {
        return ResponseEntity.ok(userService.signIn(signInRequestDto.toEntity()));
    }
}

