package ch.axa.projectspringboot.repositories;

import ch.axa.projectspringboot.domain.Event;
import ch.axa.projectspringboot.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends JpaRepository<Team, String> {
}
