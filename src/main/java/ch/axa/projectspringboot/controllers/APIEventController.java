package ch.axa.projectspringboot.controllers;

import ch.axa.projectspringboot.domain.Event;
import ch.axa.projectspringboot.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class APIEventController {

    @Autowired
    EventRepository eventRepository;

    @GetMapping
    public Iterable<Event> getAllEvents() {
        return eventRepository.findAll();
    }





}
