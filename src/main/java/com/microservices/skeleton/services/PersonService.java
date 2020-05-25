package com.microservices.skeleton.services;

import com.microservices.skeleton.beans.PersonBean;
import com.microservices.skeleton.exceptions.SkeletonApiException;

/**
 * @author German Vazquez Renteria
	* @id GermanVR
 * @url	https://github.com/GermanVR
 */
public interface PersonService {
    public PersonBean getPerson(PersonBean person) throws SkeletonApiException;
}
