package com.domingoslatrre.springlocking.repository;

import com.domingoslatrre.springlocking.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;
import java.util.Optional;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select e from Event e where e.id = :id")
    Optional<Event> findByIdWithPessimisticLock(UUID id);

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @Query("select e from Event e where e.id = :id")
    Optional<Event> findByIdWithOptimisticLock(UUID id);

//    @Query(
//        value = "update event set comment_count = :commentCount, version = version + 1 where id = :id and version = :version",
//        nativeQuery = true
//    )
//    int updateEventWithVersion(UUID id);
}
