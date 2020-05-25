package com.microservices.skeleton.responses;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;

/**
 * @author German Vazquez Renteria
 * @id GermanVR
 * @url https://github.com/GermanVR
 * @param <T>
 */
@Getter
public class ResponseExceptionBean<T> extends Response<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String appCode;

    public ResponseExceptionBean(Integer status, T payload, List<String> messages, String appCode) {
        super(status, payload, messages);
        this.appCode = appCode;
    }

}
