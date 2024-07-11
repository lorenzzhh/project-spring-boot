package ch.axa.projectspringboot.repositories;

import ch.axa.projectspringboot.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {
}
