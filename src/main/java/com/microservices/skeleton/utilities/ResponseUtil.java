package com.microservices.skeleton.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.microservices.skeleton.responses.ResponseBean;
import com.microservices.skeleton.responses.ResponseExceptionBean;


/**
 * @author German Vazquez Renteria
	* @id GermanVR
 * @url	https://github.com/GermanVR
 */
@Component
public class ResponseUtil {

    public <T> ResponseExceptionBean<T> createExceptionResponse(Integer status, String appCode, List<String> messages) {
        return new ResponseExceptionBean<>(status, null, messages, appCode);
    }

    public <T> ResponseBean<T> successResponse(T payload, String... messages) {
        return new ResponseBean<>(HttpStatus.OK.value(), payload, createMessages(messages));
    }

    private List<String> createMessages(String... messages) {
        return messages != null ? Arrays.asList(messages) : new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    public <T> ResponseEntity<T> successResponseEntity(Object response, String message) {
        ResponseBean<Object> successResponse = successResponse(response, message);
        return new ResponseEntity<>((T) successResponse, HttpStatus.valueOf(successResponse.getStatus()));
    }

}