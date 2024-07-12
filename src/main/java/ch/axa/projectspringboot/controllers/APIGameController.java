package ch.axa.projectspringboot.controllers;

import ch.axa.projectspringboot.domain.Game;
import ch.axa.projectspringboot.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/games")
@CrossOrigin("http://localhost:3000/")
public class APIGameController {

    @Autowired
    GameRepository gameRepository;

    @GetMapping
    public Iterable<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable String id) {
        return ResponseEntity.of(gameRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Game> deleteGameById(@PathVariable String id) {
        Optional<Game> game = gameRepository.findById(id);
        if (game.isPresent()) {
            gameRepository.delete(game.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        gameRepository.save(game);
        return ResponseEntity.ok(game);
    }

    @PutMapping
    public ResponseEntity<Game> updateGame(@RequestBody Game game) {
        gameRepository.save(game);
        return ResponseEntity.ok(game);
    }


}
