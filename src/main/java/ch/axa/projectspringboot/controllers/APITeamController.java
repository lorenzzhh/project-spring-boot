package ch.axa.projectspringboot.controllers;

import ch.axa.projectspringboot.domain.Team;
import ch.axa.projectspringboot.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class APITeamController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping
    public Iterable<Team> getAllTeams() {
        return teamRepository.findAll();
    }





}
