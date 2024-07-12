package ch.axa.projectspringboot.controllers;

import ch.axa.projectspringboot.domain.Stadium;
import ch.axa.projectspringboot.domain.Stadium;
import ch.axa.projectspringboot.repositories.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stadiums")
public class APIStadiumController {

    @Autowired
    StadiumRepository stadiumRepository;

    @GetMapping
    public Iterable<Stadium> getAllStadiums() {
        return stadiumRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stadium> getStadiumById(@PathVariable String id) {
        return ResponseEntity.of(stadiumRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Stadium> deleteStadiumById(@PathVariable String id) {
        Optional<Stadium> stadium = stadiumRepository.findById(id);
        if (stadium.isPresent()) {
            stadiumRepository.delete(stadium.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Stadium> createStadium(@RequestBody Stadium stadium) {
        stadiumRepository.save(stadium);
        return ResponseEntity.ok(stadium);
    }

    @PutMapping
    public ResponseEntity<Stadium> updateStadium(@RequestBody Stadium stadium) {
        stadiumRepository.save(stadium);
        return ResponseEntity.ok(stadium);
    }



}
