package com.microservices.skeleton.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author German Vazquez Renteria
	* @id GermanVR
 * @url	https://github.com/GermanVR
 * @param <T>
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Response<T> {

    private Integer status;
    private T payload;
    private List<String> messages;

}
