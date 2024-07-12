package ch.axa.projectspringboot.controllers;

import ch.axa.projectspringboot.domain.Event;
import ch.axa.projectspringboot.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/events")
@CrossOrigin("http://localhost:3000/")
public class APIEventController {

    @Autowired
    EventRepository eventRepository;

    @GetMapping
    public Iterable<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable String id) {
        return ResponseEntity.of(eventRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Event> deleteEventById(@PathVariable String id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            eventRepository.delete(event.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        eventRepository.save(event);
        return ResponseEntity.ok(event);
    }

    @PutMapping
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        eventRepository.save(event);
        return ResponseEntity.ok(event);
    }

}
