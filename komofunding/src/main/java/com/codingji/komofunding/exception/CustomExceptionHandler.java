package com.codingji.komofunding.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    // CustomException을 처리하는 메서드
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomErrorResponse> handleCustomException(CustomException ex) {
        CustomErrorCode errorCode = ex.getErrorCode();  // CustomException에서 ErrorCode를 추출
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                errorCode.getCode(),
                errorCode.getMessage()
        );
        return ResponseEntity.status(HttpStatus.valueOf(errorCode.getStatus()))
                .body(errorResponse);
    }
}
