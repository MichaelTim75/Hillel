package edu.hillel.lesson30.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NewsExceptionHandler {

    @ExceptionHandler(GetNewsException.class)
    public ResponseEntity<ErrorBody> handleException(Exception e){
        return new ResponseEntity<>(new ErrorBody("GET_NEWS_ERROR",e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Data
    public static class ErrorBody{
        private final String errorCode;
        private final String errorDescription;
    }
}
