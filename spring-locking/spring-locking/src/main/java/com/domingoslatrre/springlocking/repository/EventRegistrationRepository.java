package com.domingoslatrre.springlocking.repository;

import com.domingoslatrre.springlocking.model.EventRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRegistrationRepository extends JpaRepository<EventRegistration, UUID> {
}
