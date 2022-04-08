package com.o3.apiserver.common.exception;

import com.o3.apiserver.common.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler({NotFoundDataException.class, NotFoundScrapDataException.class})
    public ResponseEntity<CommonResponse<?>> notFoundException(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(CommonResponse.error(ex.getMessage()));
    }

    @ExceptionHandler({AlreadyRegisterUserException.class, NotRegisterUserException.class, NotMatchPasswordException.class, InValidTokenException.class})
    public ResponseEntity<CommonResponse<?>> alreadyRegisterException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(CommonResponse.error(ex.getMessage()));
    }
}
