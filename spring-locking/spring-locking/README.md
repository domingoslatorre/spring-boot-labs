# Spring Locking

## Pessimmistic

```java
Lock(LockModeType.PESSIMISTIC_WRITE)
@Query("select e from Event e where e.id = :id")
Optional<Event> findByIdWithPessimisticLock(UUID id);
```

## Optimistic

```java
@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
@Query("select e from Event e where e.id = :id")
Optional<Event> findByIdWithOptimisticLock(UUID id);
```

Retry optimistic with lib `com.vladmihalcea:db-util:1.0.6`

```java
@Transactional
@Retry(times = 3, on = OptimisticLockException.class)
public Pair<Event, EventRegistration> registerWithOptimisticLock(UUID eventId) {
    return transactionTemplate.execute(
        status -> {
            var event = eventRepository.findByIdWithOptimisticLock(eventId)
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
    );
}
```

