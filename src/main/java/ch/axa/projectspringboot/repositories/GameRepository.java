package ch.axa.projectspringboot.repositories;

import ch.axa.projectspringboot.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends JpaRepository<Game, String> {
}
