package com.in28minutes.restfulwebservices.controller;

import com.in28minutes.restfulwebservices.entity.versioning.Person;
import com.in28minutes.restfulwebservices.entity.versioning.name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    @GetMapping("/v1/person")
    public Person getFirstVersionOfPerson() {
        return new Person("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public Person getSecondVersionOfPerson() {
        return new Person(new name("Bob", "Charlie"));
    }

    /*@GetMapping(path = "/person", params = "version=1")
    public Person getFirstVersionOfPersonRequestParameter() {
        return new Person("Bob Charlie");
    }

    @GetMapping(path = "/person", params = "version=2")
    public Person getSecondVersionOfPersonRequestParameter() {
        return new Person(new name("Bob", "Charlie"));
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public Person getFirstVersionOfPersonRequestHeader() {
        return new Person("Bob Charlie");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public Person getSecondVersionOfPersonRequestHeader() {
        return new Person(new name("Bob", "Charlie"));
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public Person getFirstVersionOfPersonAcceptHeader() {
        return new Person("Bob Charlie");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public Person getSecondVersionOfPersonAcceptHeader() {
        return new Person(new name("Bob", "Charlie"));
    }*/
}
