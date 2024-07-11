package ch.axa.projectspringboot.repositories;

import ch.axa.projectspringboot.domain.Event;
import ch.axa.projectspringboot.domain.Stadium;
import org.springframework.data.repository.CrudRepository;

public interface StadiumRepository extends CrudRepository<Stadium, String> {
}
