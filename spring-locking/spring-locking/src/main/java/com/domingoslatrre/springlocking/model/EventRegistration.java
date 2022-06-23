package com.domingoslatrre.springlocking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventRegistration {
    @Id
    private UUID id;
    @ManyToOne
    private Event event;

    public EventRegistration(Event event) {
        this.id = UUID.randomUUID();
        this.event = event;
    }
}
