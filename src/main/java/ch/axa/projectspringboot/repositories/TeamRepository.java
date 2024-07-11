package ch.axa.projectspringboot.repositories;

import ch.axa.projectspringboot.domain.Event;
import ch.axa.projectspringboot.domain.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, String> {
}
