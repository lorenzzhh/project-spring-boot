package ch.axa.projectspringboot.domain;

import jakarta.persistence.*;

@Entity
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
