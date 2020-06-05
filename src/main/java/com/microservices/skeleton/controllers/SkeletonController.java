package com.microservices.skeleton.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.skeleton.beans.PersonBean;
import com.microservices.skeleton.services.PersonService;
import com.microservices.skeleton.utilities.ResponseUtil;

import reactor.core.publisher.Mono;

/**
 * @author German Vazquez Renteria
 * @id GermanVR
 * @url https://github.com/GermanVR
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class SkeletonController {

    @Autowired
    private PersonService personaService;

    @Autowired
    private ResponseUtil responseUtil;

    @PostMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<PersonBean>> hello(@RequestBody PersonBean person) {
        ResponseEntity<PersonBean> responseEntity = responseUtil.successResponseEntity(personaService.getPerson(person), "Success when consulting the information");
        return Mono.just(responseEntity);
    }

    @GetMapping(path = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<String>> status() {
        return Mono.just(responseUtil.successResponseEntity("UP", "The application Works fine!!!"));
    }

}