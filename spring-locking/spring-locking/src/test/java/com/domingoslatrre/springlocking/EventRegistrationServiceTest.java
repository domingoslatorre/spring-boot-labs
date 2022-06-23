package com.domingoslatrre.springlocking;

import com.domingoslatrre.springlocking.model.Event;
import com.domingoslatrre.springlocking.repository.EventRepository;
import com.domingoslatrre.springlocking.service.EventRegistrationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventRegistrationServiceTest {
    @Autowired
    private EventRegistrationService eventRegistrationService;
    @Autowired
    private EventRepository eventRepository;

    @Test
    public void concurrentRegistration() {
        Event event = new Event("Best Event A", 20);
        eventRepository.save(event);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                eventRegistrationService.register(event.getId());
            }).start();
        }
    }

    @Test
    public void concurrentRegistrationWithPessimisticLock() {
        Event event = new Event("Best Event A", 100);
        eventRepository.save(event);
        UUID eventId = event.getId();
        for (int i = 0; i < 300; i++) {
            new Thread(() -> {
                eventRegistrationService.registerWithPessimisticLock(eventId);
            }).start();
        }
    }

    @Test
    public void concurrentRegistrationWithtOptimisticLock() throws InterruptedException {
        Event event = new Event("Best Event A", 100);
        eventRepository.save(event);
        UUID eventId = event.getId();
        for (int i = 0; i < 110; i++) {
            Thread.sleep(100L);
            new Thread(() -> {
                eventRegistrationService.registerWithOptimisticLock(eventId);
            }).start();
        }
    }
}
