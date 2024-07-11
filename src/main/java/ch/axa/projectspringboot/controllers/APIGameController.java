package ch.axa.projectspringboot.controllers;

import ch.axa.projectspringboot.domain.Game;
import ch.axa.projectspringboot.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/games")
public class APIGameController {

    @Autowired
    GameRepository gameRepository;

    @GetMapping
    public Iterable<Game> getAllGames() {
        return gameRepository.findAll();
    }





}
