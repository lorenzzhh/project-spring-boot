package ch.axa.projectspringboot;

import ch.axa.projectspringboot.domain.*;
import ch.axa.projectspringboot.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class Dataloader implements ApplicationRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private StadiumRepository stadiumRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {


        for (int i = 0; i < 5; i++) {

            Team team = new Team();
            team.setName("Team " + i);
            teamRepository.save(team);

            Team team1 = new Team();
            team1.setName("Team1 " + i);
            teamRepository.save(team1);

            Person person = new Person();
            person.setName("Ronaldo " + i);
            person.setTeam(team);
            personRepository.save(person);

            Stadium stadium = new Stadium();
            stadium.setName("Stadium " + i);
            stadiumRepository.save(stadium);

            Game game = new Game();
            game.setName("Game " + i);
            game.setStadium(stadium);

            HashSet<Team> teams = new HashSet<>();
            teams.add(team);
            teams.add(team1);
            game.setTeams(teams);
            gameRepository.save(game);

            Event event = new Event();
            event.setDescription("Rote Karte " + i);
            event.setMinute(i);
            event.setPerson(person);
            event.setGame(game);
            eventRepository.save(event);


        }


    }
}
