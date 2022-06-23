package com.domingoslatrre.springlocking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Event {
    @Id
    private UUID id;
    private String title;
    private int numberOfSeats;
    private int numberOfReservedSeats;

    @Version
    private int version;

    public Event(String title, int numberOfSeats) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.numberOfSeats = numberOfSeats;
        this.numberOfReservedSeats = 0;
    }

    public boolean isFull() {
        return numberOfReservedSeats == numberOfSeats;
    }

    public void incrementNumberOfReservedSeats() {
        numberOfReservedSeats++;
    }
}
