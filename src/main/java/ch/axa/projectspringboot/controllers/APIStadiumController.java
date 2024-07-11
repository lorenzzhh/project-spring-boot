package ch.axa.projectspringboot.controllers;

import ch.axa.projectspringboot.domain.Stadium;
import ch.axa.projectspringboot.repositories.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stadiums")
public class APIStadiumController {

    @Autowired
    StadiumRepository stadiumRepository;

    @GetMapping
    public Iterable<Stadium> getAllStadiums() {
        return stadiumRepository.findAll();
    }





}
