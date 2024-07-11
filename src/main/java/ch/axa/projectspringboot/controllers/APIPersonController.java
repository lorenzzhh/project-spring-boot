package ch.axa.projectspringboot.controllers;

import ch.axa.projectspringboot.domain.Event;
import ch.axa.projectspringboot.domain.Person;
import ch.axa.projectspringboot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/people")
public class APIPersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping
    public Iterable<Person> getAllEvents() {
        return personRepository.findAll();
    }





}
