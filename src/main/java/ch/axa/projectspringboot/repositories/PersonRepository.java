package ch.axa.projectspringboot.repositories;

import ch.axa.projectspringboot.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends JpaRepository<Person, String> {

}
