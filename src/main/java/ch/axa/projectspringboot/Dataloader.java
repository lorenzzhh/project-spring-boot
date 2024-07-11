package ch.axa.projectspringboot;

import ch.axa.projectspringboot.domain.*;
import ch.axa.projectspringboot.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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

            Person person = new Person();
            person.setName("Ronaldo " + i);
            personRepository.save(person);

            Event event = new Event();
            event.setDescription("Rote Karte " + i);
            event.setMinute(i);
            event.setPerson(person);
            eventRepository.save(event);

            Game game = new Game();
            game.setName("Game " + i);
            gameRepository.save(game);

            Team team = new Team();
            team.setName("Team " + i);
            teamRepository.save(team);

            Stadium stadium = new Stadium();
            stadium.setName("Stadium " + i);
            stadiumRepository.save(stadium);
        }


    }
}
