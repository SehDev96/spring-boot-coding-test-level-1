package com.codejam.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                            WebRequest webRequest) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                exception.getMessage(),
                webRequest.getDescription(false),
                new Date()
        );
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceExistException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFoundException(ResourceExistException exception,
                                                                            WebRequest webRequest) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                exception.getMessage(),
                webRequest.getDescription(false),
                new Date()
        );
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleInternalServerErrorException(Exception ex) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse();

        if (ex instanceof NullPointerException) {
            apiErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
            apiErrorResponse.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
            apiErrorResponse.setMessage("An Unexpected Error Occured");
            apiErrorResponse.setDetails(ex.getLocalizedMessage());
            apiErrorResponse.setTimestamp(new Date());
            return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
        }

        apiErrorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiErrorResponse.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        apiErrorResponse.setMessage("An Unexpected Error Occured");
        apiErrorResponse.setDetails(ex.getLocalizedMessage());
        apiErrorResponse.setTimestamp(new Date());
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
