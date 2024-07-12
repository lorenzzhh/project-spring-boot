package ch.axa.projectspringboot.controllers;

import ch.axa.projectspringboot.domain.Person;
import ch.axa.projectspringboot.domain.Person;
import ch.axa.projectspringboot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/people")
@CrossOrigin("http://localhost:3000/")
public class APIPersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping
    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable String id) {
        return ResponseEntity.of(personRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> deletePersonById(@PathVariable String id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            personRepository.delete(person.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        personRepository.save(person);
        return ResponseEntity.ok(person);
    }

    @PutMapping
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        personRepository.save(person);
        return ResponseEntity.ok(person);
    }


}
