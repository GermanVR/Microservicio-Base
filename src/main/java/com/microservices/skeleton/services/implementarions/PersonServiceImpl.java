package com.microservices.skeleton.services.implementarions;

import org.springframework.stereotype.Service;

import com.microservices.skeleton.beans.PersonBean;
import com.microservices.skeleton.exceptions.DefaultAppException;
import com.microservices.skeleton.services.PersonService;

/**
 * @author German Vazquez Renteria
 * @id GermanVR
 * @url https://github.com/GermanVR
 */
@Service
public class PersonServiceImpl implements PersonService {

	@Override
	public PersonBean getPerson(PersonBean person) {
		if (person.getAge() == null || person.getAge() <= 0 || person.getLastName() == null || person.getName() == null) {
			throw new DefaultAppException("Invalid Person Object");
		}
		if (person.getAge() < 18) {
			throw new DefaultAppException("The person is a minor");
		}
		return person;
	}
}