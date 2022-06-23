package com.domingoslatrre.springlocking.service;

import com.domingoslatrre.springlocking.model.Event;
import com.domingoslatrre.springlocking.model.EventRegistration;
import com.domingoslatrre.springlocking.repository.EventRegistrationRepository;
import com.domingoslatrre.springlocking.repository.EventRepository;
import com.vladmihalcea.concurrent.Retry;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.OptimisticLockException;
import java.util.UUID;

@Service
@AllArgsConstructor
@Log
public class EventRegistrationService {
    private final EventRepository eventRepository;
    private final EventRegistrationRepository eventRegistrationRepository;
    private final TransactionTemplate transactionTemplate;

    @Transactional
    public Pair<Event, EventRegistration> register(UUID eventId) {
        var event = eventRepository.findById(eventId)
            .orElseThrow(() -> new RuntimeException("Event notfound"));

        if(event.isFull()) {
            throw new RuntimeException("Event is full");
        }

        var eventRegistration = new EventRegistration(event);
        eventRegistrationRepository.save(eventRegistration);

        event.incrementNumberOfReservedSeats();
        eventRepository.save(event);

        return Pair.of(event, eventRegistration);
    }

    @Transactional
    public Pair<Event, EventRegistration> registerWithPessimisticLock(UUID eventId) {
        var event = eventRepository.findByIdWithPessimisticLock(eventId)
            .orElseThrow(() -> new RuntimeException("Event notfound"));

        if(event.isFull()) {
            throw new RuntimeException("Event is full");
        }

        var eventRegistration = new EventRegistration(event);
        eventRegistrationRepository.save(eventRegistration);

        event.incrementNumberOfReservedSeats();
        eventRepository.save(event);

        return Pair.of(event, eventRegistration);
    }

    @Transactional
    @Retry(times = 3, on = OptimisticLockException.class)
    public Pair<Event, EventRegistration> registerWithOptimisticLock(UUID eventId) {
        return transactionTemplate.execute(
            status -> {
                System.out.println(eventId);
                var event = eventRepository.findByIdWithOptimisticLock(eventId)
                    .orElseThrow(() -> new RuntimeException("Event notfound"));

                if(event.isFull()) {
                    System.out.println("FULLL");
                    throw new RuntimeException("Event is full");
                }

                var eventRegistration = new EventRegistration(event);
                eventRegistrationRepository.save(eventRegistration);

                event.incrementNumberOfReservedSeats();
                eventRepository.save(event);

                return Pair.of(event, eventRegistration);
            }
        );
    }

}
