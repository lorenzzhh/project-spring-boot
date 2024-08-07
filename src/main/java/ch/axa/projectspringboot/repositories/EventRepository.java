package ch.axa.projectspringboot.repositories;

import ch.axa.projectspringboot.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends JpaRepository<Event, String> {
}
