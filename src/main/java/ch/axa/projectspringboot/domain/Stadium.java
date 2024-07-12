package ch.axa.projectspringboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @JsonIgnoreProperties({"stadium", "events"})
    @OneToMany(mappedBy = "stadium")
    private Set<Game> games = new HashSet<>();

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> events) {
        this.games = events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
