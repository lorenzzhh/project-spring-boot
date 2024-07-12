package ch.axa.projectspringboot.controllers;

import ch.axa.projectspringboot.domain.Team;
import ch.axa.projectspringboot.domain.Person;
import ch.axa.projectspringboot.domain.Team;
import ch.axa.projectspringboot.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/teams")
public class APITeamController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping
    public Iterable<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable String id) {
        return ResponseEntity.of(teamRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Team> deleteTeamById(@PathVariable String id) {
        Optional<Team> team = teamRepository.findById(id);
        if (team.isPresent()) {
            teamRepository.delete(team.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        teamRepository.save(team);
        return ResponseEntity.ok(team);
    }

    @PutMapping
    public ResponseEntity<Team> updateTeam(@RequestBody Team team) {
        teamRepository.save(team);
        return ResponseEntity.ok(team);
    }
    
    

    @GetMapping("/{id}/players")
    public Set<Person> getTeamPlayers(@PathVariable String id) {
        return teamRepository.findById(id).get().getPeople();
    }


}
