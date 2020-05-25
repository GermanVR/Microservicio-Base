package com.microservices.skeleton.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author German Vazquez Renteria
 * @id GermanVR
 * @url https://github.com/GermanVR
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonBean {

    private String name;
    private String lastName;
    private Integer age;

}