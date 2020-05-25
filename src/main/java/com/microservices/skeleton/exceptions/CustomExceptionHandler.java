package com.microservices.skeleton.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.microservices.skeleton.responses.ResponseBean;
import com.microservices.skeleton.responses.ResponseExceptionBean;
import com.microservices.skeleton.utilities.ResponseUtil;

/**
 * @author German Vazquez Renteria
 * @id GermanVR
 * @url https://github.com/GermanVR
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ResponseUtil response;

    @ExceptionHandler({ DefaultAppException.class })
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {

        if (ex instanceof DefaultAppException) {
            return applicationException((DefaultAppException) ex, request);
        } else {
            throw ex;
        }
    }

    protected ResponseEntity<Object> applicationException(DefaultAppException ex, WebRequest request) {
        List<String> details = generateErrorList(ex.getLocalizedMessage());
        ResponseExceptionBean<Object> errors = response.createExceptionResponse(ex.getHttpStatus(), ex.getId(), details);
        return new ResponseEntity<>(errors, HttpStatus.valueOf(ex.getHttpStatus()));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Required request body is missing";
        List<String> details = generateErrorList(ex.getLocalizedMessage(), error);
        ResponseBean<String> errors = new ResponseBean<>(status.value(), null, details);
        return buildResponseEntity(errors, status);
    }

    private List<String> generateErrorList(String... errors) {
        List<String> details = new ArrayList<>();
        Arrays.stream(errors).forEach(details::add);
        return details;
    }

    private ResponseEntity<Object> buildResponseEntity(ResponseBean<String> error, HttpStatus status) {
        return new ResponseEntity<>(error, status);
    }

}