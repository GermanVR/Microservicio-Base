package com.microservices.skeleton.responses;

import java.io.Serializable;
import java.util.List;

/**
 * @author German Vazquez Renteria
 * @id GermanVR
 * @url https://github.com/GermanVR
 * @param <T>
 */
public class ResponseBean<T> extends Response<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public ResponseBean(Integer status, T payload, List<String> messages) {
        super(status, payload, messages);
    }

}
