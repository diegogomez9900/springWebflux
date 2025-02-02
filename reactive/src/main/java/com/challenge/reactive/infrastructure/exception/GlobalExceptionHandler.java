package com.challenge.reactive.infrastructure.exception;


import com.challenge.reactive.infrastructure.classes.GenericResponse;
import com.challenge.reactive.infrastructure.classes.enumclasses.EnumResponses;
import com.challenge.reactive.infrastructure.exception.classes.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<GenericResponse>> handleException(Exception exception) {
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GenericResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), exception.getMessage())));
    }

    @ExceptionHandler(SavingException.class)
    public Mono<ResponseEntity<GenericResponse>> handleSavingException(SavingException exception) {
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GenericResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), exception.getMessage())));
    }

    @ExceptionHandler(UpdatingException.class)
    public Mono<ResponseEntity<GenericResponse>> handleUpdatingException(UpdatingException exception) {
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GenericResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                        exception.getMessage().contains(EnumResponses.ERROR_001.getMessage()) ?
                                exception.getMessage() : EnumResponses.ERROR_002.getMessage())));
    }

    @ExceptionHandler(AddException.class)
    public Mono<ResponseEntity<GenericResponse>> handleUpdatingException(AddException exception) {
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GenericResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), exception.getMessage())));
    }

    @ExceptionHandler(DeletingException.class)
    public Mono<ResponseEntity<GenericResponse>> handleDeletingException(DeletingException exception) {
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GenericResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), exception.getMessage())));
    }

    @ExceptionHandler(GettingException.class)
    public Mono<ResponseEntity<GenericResponse>> handleGettingException(GettingException exception) {
        return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new GenericResponse(
                        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), exception.getMessage())));
    }
}
