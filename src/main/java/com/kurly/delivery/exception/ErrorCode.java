package com.kurly.delivery.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DUPLICATED_EMAIL (HttpStatus.BAD_REQUEST, "해당 이메일이 중복됩니다."),
    NOT_FOUND_ENTITY (HttpStatus.NOT_FOUND, "해당 객체를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 에러")
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
